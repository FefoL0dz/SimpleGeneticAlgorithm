package main.controllers;


import main.controllers.operators.crossover.CrossoverImpl;
import main.controllers.operators.mutation.MutationImpl;
import main.controllers.operators.selection.Selection;
import main.controllers.operators.selection.SelectionImpl;
import main.models.pojo.Phenotype;
import main.models.pojo.Population;
import main.controllers.algorithmTools.math.conversors.Binary2Decimal;
import main.controllers.algorithmTools.math.functions.fitnessFunctions.Fitness;
import main.controllers.algorithmTools.math.functions.fitnessFunctions.FitnessImpl;
import main.controllers.algorithmTools.calendar.Calendar;
import main.utils.analytics.analyticsDataModel.CurrentInformationData;
import main.utils.analytics.analyticsDataModel.ProblemConfigurationData;
import main.utils.analytics.analyticsLoggerModel.Logger;
import main.utils.clock.Timer;

import java.util.Arrays;


/**
 * This algorithm uses Rastrigins function, dimensional space equals to 3, Roulette as selector component,  as default configuration
 */
public class Handler extends HandlerConfigFile {

    private Population population;

    private Calendar calendar;

    private Fitness fitnessFunc;

    private Population oldPopulation;

    private Selection selectionOperator;

    private Logger logger;

    private Timer timer;

    public Handler
    (int populationSize,
     int endOfTimes,
     double mutationProbability,
     double crossoverProbability) {
        timer = new Timer();
        validateInputs(populationSize, endOfTimes, mutationProbability, crossoverProbability);

        generateCalendar(endOfTimes);
        generateRandomPopulation(populationSize);
        generateGAOperators(mutationProbability, crossoverProbability);
        generateFitnessFunc();

        if(loggerEnable)
        generateLogger();

        oldPopulation = new Population(populationSize);
    }

    private void validateInputs(int populationSize, int endOfTimes, double mutationProbability, double crossoverProbability) {
        String errorMessage = "";
        boolean throwError = false;
        if(populationSize <= 0){
            errorMessage = "Empty population!";
            throwError = true;
        }
        if(endOfTimes < 0){
            errorMessage = "Number of seasons is less than zero!";
            throwError = true;
        }
        if(numberOfRepresentationBits <= 0){
            errorMessage = "Individuals don't have genotype!";
            throwError = true;
        }
        if(mutationProbability < 0 || crossoverProbability < 0){
            errorMessage = "Negative probability!";
            throwError = true;
        }
         if(throwError == true)   throw new IllegalArgumentException(errorMessage);
    }


   public Phenotype runGettingBestIndividual() {
        run();
       //TODO: See if I should Calculate instead of saving instance to avoid inconsistency
       //TODO: this is a test method and it should be deleted after used
       this.population.findBestIndividual();
       return this.population.getBestIndividual();
   }

    public void run() {
        calculatePopulationFitness();
        while(!calendar.isNowTheEndOfTimes()) {
            iterateGeneration();
            if(loggerEnable) log();
            calendar.updateEpoch();
        }
        showInfos();
    }

    private void iterateGeneration() {
        if(isOverfittingHappening()) {
            this.selectionOperator.getMutationOperator().setMutationProbability(
                    this.selectionOperator.getMutationOperator().getMutationProbability() + mutationIncreaseRate
            );
            timesMutationWasIncreased ++;
        }
        else if(isUnderfittingHappening()){
            this.selectionOperator.getMutationOperator().setMutationProbability(
                    this.selectionOperator.getMutationOperator().getMutationProbability() - mutationIncreaseRate
            );
            timesMutationWasIncreased --;
        }
        evolvePopulation();
        calculatePopulationFitness();
    }
    private boolean isUnderfittingHappening() {
        if(this.population.getAveragePopFitness() <
                (this.population.getBestIndividual().getAbsoluteFitness() * (1 - threshold)) && timesMutationWasIncreased > 0)
            return true;
        return false;
    }
    private boolean isOverfittingHappening() {
        if(this.population.getAveragePopFitness() >=
                (this.population.getBestIndividual().getAbsoluteFitness() * (1 - threshold)) && timesMutationWasIncreased == 0)
            return true;
        return false;
    }

    private void evolvePopulation() {
        agingPopulation();

        int offset = 0;

        if(elitism) {
            offset = 1;
            population.setNewIndividual(0, oldPopulation.getBestIndividual());
        }
        Population newPop = selectionOperator.selectIndividuals(oldPopulation, population, offset);
        population.setIndividuals(newPop.getIndividuals());
    }

    private void agingPopulation() {
        oldPopulation.setIndividuals(population.getIndividuals());
        oldPopulation.setTotalPopulationFitness(population.getTotalPopulationFitness());
        oldPopulation.setBestIndividual(population.getBestIndividual());
        population.clearPopulation();
    }

    private void calculatePopulationFitness() {
        calculateTotalAbsolutePopulationFitness();
        calculateRelativeIndividualsFitness();
        this.population.findBestIndividual();
    }

    private void calculateTotalAbsolutePopulationFitness() {

        double totalPopulationFitnessCounter = 0.0;

        population.setBestIndividual(population.getIndividuals()[0]);

        for (int i = 0; i < this.population.getPopulationSize(); i++) {
            Phenotype current = population.getIndividuals()[i];

            int x = Binary2Decimal //going until half of vector
                    .convertBin2Dec(current.getGenotype(), 0, 9);

            int y = Binary2Decimal //going from half until end of vector
                    .convertBin2Dec(current.getGenotype(), 10, 19);

            double X = this.q.getNormalizedValue(x);
            double Y = this.q.getNormalizedValue(y);

            double absoluteCurrentIndividualFitness = this.fitnessFunc.calculateFitness(X , Y);

            population.getIndividuals()[i].setAbsoluteFitness(absoluteCurrentIndividualFitness);

            totalPopulationFitnessCounter += absoluteCurrentIndividualFitness;
        }
        population.setTotalPopulationFitness(totalPopulationFitnessCounter);
    }

    private void calculateRelativeIndividualsFitness() {
        for (int i = 0; i < this.population.getPopulationSize(); i++) {
            double relativeCurrentIndividualFitness = population.getIndividuals()[i].getAbsoluteFitness()/population.getTotalPopulationFitness();
            population.getIndividuals()[i].setRelativeFitness(relativeCurrentIndividualFitness);
        }
    }

    //generators
    private void generateRandomPopulation(int populationSize) {
        this.population = Population
                .generateRandomPopulation(populationSize, numberOfRepresentationBits * (DIMENSIONAL_SPACE - 1));
    }

    private void generateCalendar(int endOfTimes) {
        this.calendar = new Calendar(endOfTimes);
    }

    private void generateGAOperators(double mutationProbability, double crossoverProbability) {
        //TODO: implements another mutation operator because these two operators has problems -
        // the first it's absolutely brute and mutates too much -
        // the second doesn't mutate when the value it's too near of zero (0 x random value = 0)
        this.selectionOperator = new SelectionImpl(new CrossoverImpl(crossoverProbability), new MutationImpl(mutationProbability));
    }

    private void generateFitnessFunc() {
        this.fitnessFunc = new FitnessImpl(function);
    }

    private void generateLogger() {
       logger = new Logger();
       logger.initialLog(generateProblemConfigurationData());
    }
    //Log and Data generators
    private void log(){
       logger.log(generateCurrentInformationData());
    }

    private CurrentInformationData generateCurrentInformationData() {
      String currentEpoch = String.valueOf(this.calendar.getCurrentEpoch());
      String time = String.valueOf(this.timer.getString());
      String crossProb = String.valueOf(this.selectionOperator.getCrossoverOperator().getCrossoverProbability());
      String mutProb = String.valueOf(this.selectionOperator.getMutationOperator().getMutationProbability());

      String totalPopFitness = String.valueOf(this.population.getTotalPopulationFitness());
      String averagePopFitness = String.valueOf(this.population.getAveragePopFitness());

      Phenotype best = this.population.getBestIndividual();

      String bestPhenotypeId = String.valueOf(best.getId());
      String bestPhenotypeGenotype = Arrays.toString(best.getGenotype());
      String bestPhenotypeAbsFitness = String.valueOf(best.getAbsoluteFitness());
      String bestPhenotypeRelFitness = String.valueOf(best.getRelativeFitness());

      CurrentInformationData data =
              new CurrentInformationData(currentEpoch, time, crossProb, mutProb, totalPopFitness, averagePopFitness,
                      bestPhenotypeId, bestPhenotypeGenotype, bestPhenotypeAbsFitness, bestPhenotypeRelFitness);

      return data;
    }

    private ProblemConfigurationData generateProblemConfigurationData() {
       String popSize = String.valueOf(population.getPopulationSize());
       String numberOfRepBits = String.valueOf(numberOfRepresentationBits);
       String genotypeSize = String.valueOf(this.population.getIndividuals()[0].getGenotypeSize());
       String endOfTimes = String.valueOf(this.calendar.getEndOfTimes());
       String mutationProb = String.valueOf(this.selectionOperator.getMutationOperator().getMutationProbability());
       String crossoverProb = String.valueOf(this.selectionOperator.getCrossoverOperator().getCrossoverProbability());
       String function = this.function.getFuncName();
       String minVar = String.valueOf(minVariable);
       String maxVar = String.valueOf(maxVariable);
       String dimensionalSpace = String.valueOf(this.DIMENSIONAL_SPACE);

       String belief = String.valueOf(elitism);
       String thresholdRate = String.valueOf(threshold);
       String mutationIncRate = String.valueOf(mutationIncreaseRate);
       String currentTime = String.valueOf(this.timer.getString());

       ProblemConfigurationData data = new ProblemConfigurationData(popSize, numberOfRepBits, genotypeSize, endOfTimes,
               mutationProb, crossoverProb, function, minVar, maxVar, dimensionalSpace, belief, thresholdRate, mutationIncRate, currentTime);
       return data;
    }

    //exhibitors
    public void showInfos() {
        System.out.println("**********************************************************************");
        System.out.println("Execution information: \n");
        showPopulationInfos();
        showOperators();
        showCalendarInfos();
        showDefaultConfigInfos();
        System.out.println("\n**********************************************************************");
    }

    public void showPopulationInfos() { this.population.showInfos(); }

    public void showCalendarInfos() { this.calendar.showInfos(); }

    public void showOperators() {
        this.selectionOperator.getMutationOperator().showMutationProbability();
        this.selectionOperator.getCrossoverOperator().showCrossoverProbability();
    }

}
