package main.controllers.operators.selection;

import main.controllers.operators.GeneticAlgorithmOperator;
import main.controllers.operators.crossover.Crossover;
import main.controllers.operators.mutation.Mutation;
import main.models.pojo.Phenotype;
import main.models.pojo.Population;

import java.util.Random;

public class SelectionImpl implements GeneticAlgorithmOperator, Selection {

   private Crossover crossoverOperator;

   private Mutation mutationOperator;

    public SelectionImpl(Crossover crossoverOperator, Mutation mutationOperator) {
        this.crossoverOperator = crossoverOperator;
        this.mutationOperator = mutationOperator;
    }

    @Override
    public Crossover getCrossoverOperator() {
        return crossoverOperator;
    }

    @Override
    public void setCrossoverOperator(Crossover crossoverOperator) {
        this.crossoverOperator = crossoverOperator;
    }

    @Override
    public Mutation getMutationOperator() {
        return mutationOperator;
    }

    @Override
    public void setMutationOperator(Mutation mutationOperator) {
        this.mutationOperator = mutationOperator;
    }

    @Override
   public Population selectIndividuals(Population oldPopulation, Population newPopulation, int offset) {

        int newPopInitialPoint = offset;

        //Crossover
        for (int i = 0; i < (oldPopulation.getPopulationSize() - newPopInitialPoint); i++, offset++)
        {
            Phenotype individual1 = runRouletteWheel(oldPopulation);
            Phenotype individual2 = runRouletteWheel(oldPopulation);
            Phenotype newIndividual;
            if(generateRandomValue() <= this.crossoverOperator.getCrossoverProbability())
               newIndividual = crossoverOperator.performCrossover(individual1, individual2, offset);
            else
                { //Clone individual
                if(generateRandomValue() < 0.5)
                    newIndividual = individual1;
                else
                    newIndividual = individual2;
                }
            newPopulation.setNewIndividual(offset, new Phenotype(offset, newIndividual.getGenotype()));
            //newPopulation.setNewIndividual(offset, newIndividual);
        }

        //Mutation
        for (int i = newPopInitialPoint; i < oldPopulation.getPopulationSize(); i++) // not mutating fist individual for the "elitist belief"
        {
            if(generateRandomValue() <= this.mutationOperator.getMutationProbability()) {
                Phenotype xManIndividual = this.mutationOperator.performMutation(newPopulation.getIndividuals()[i]);
                newPopulation.getIndividuals()[i].setGenotype(xManIndividual.getGenotype());
            }
        }
        return newPopulation;
    }



    private Phenotype runRouletteWheel(Population oldPopulation) {
        double randomValue = generateRandomValue();
        double fitnessCounter = 0.0;
        Phenotype chosen = null;
        for (int i = 0; i < oldPopulation.getPopulationSize(); i++) {
            //TODO: verify if the relative fitness is already calculated!
            fitnessCounter += oldPopulation.getIndividuals()[i].getRelativeFitness();
            if(randomValue <= fitnessCounter){
                chosen = oldPopulation.getIndividuals()[i];
                i = oldPopulation.getPopulationSize();
            }
        }
        if(chosen == null) throw new IllegalArgumentException("Roulette logic is poorly implemented!");
        return chosen;
    }

    private double generateRandomValue(){
        Random rand = new Random();
        double randomValue = 0.0 + (1.0 - 0.0) * rand.nextDouble();
        return randomValue;
    }

}
