package main.models.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Population {

    private int populationSize;
    private Phenotype[] individuals;
    private Double totalPopulationFitness;
    private Phenotype bestIndividual;

    public Population(int populationSize, Phenotype[] individuals) {
        this.populationSize = populationSize;
        this.individuals = individuals;
        totalPopulationFitness = null;
        bestIndividual = null;
    }

    public Population(int populationSize) {
        this.populationSize = populationSize;
        this.individuals = new Phenotype[populationSize];
        totalPopulationFitness = null;
        bestIndividual = null;
    }

    /*public void updateTotalPopFitnessValue() {
        double totalFitnessValue = 0.0;
        for (int i = 0; i < this.populationSize; i++) {
            if(individuals[i].getAbsoluteFitness() == null) throw new IllegalArgumentException("Individual fitness not initialized yet!");
            totalFitnessValue += individuals[i].getAbsoluteFitness();
        }
        this.totalPopulationFitness = totalFitnessValue;
    }*/

    public void findBestIndividual() {
        int bestIndividualIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            //if(individuals[i].getRelativeFitness() > individuals[bestIndividualIndex].getRelativeFitness())
            if(individuals[i].getAbsoluteFitness() >= individuals[bestIndividualIndex].getAbsoluteFitness())
                bestIndividualIndex = i;
        }
        setBestIndividual(individuals[bestIndividualIndex]);
    }

    public void compareWithBestIndividual(int index) {
        if(this.bestIndividual == null){
            this.findBestIndividual();
        }
        else{
            if(bestIndividual.getAbsoluteFitness() < this.individuals[index].getAbsoluteFitness())
                this.setBestIndividual(this.individuals[index]);
        }
    }

    public void clearPopulation() { //it's not a genocide!!
        this.setIndividuals(null);
        this.setBestIndividual(null);
        this.setTotalPopulationFitness(null);
        this.individuals = new Phenotype[populationSize];
    }

    //getters
    public Phenotype[] getIndividuals() {
        return individuals;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public Double getTotalPopulationFitness() { return totalPopulationFitness; }

    public Double getAveragePopFitness() { return this.totalPopulationFitness/this.populationSize; } //uses the absolute fitness instead of relative one

    public Phenotype getBestIndividual() { return this.bestIndividual; }

    //setters
    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public void setIndividuals(Phenotype[] individuals) {
        this.individuals = individuals;
    }

    public void setTotalPopulationFitness(Double totalPopulationFitness) {
        this.totalPopulationFitness = totalPopulationFitness;
    }

    public void setBestIndividual(Phenotype theBest) {this.bestIndividual = theBest; }

    public void setRandomPopulation(int genotypeSize) {
        this.individuals = generateRandomIndividuals(this.populationSize, genotypeSize);
    }

    public void setNewIndividual(int index, Phenotype individual) {
        if(this.individuals[index] == null) {
            this.individuals[index] = individual;
//            compareWithBestIndividual(index);
        }
        else throw new IllegalArgumentException(
                "This individual can't be added to this position of society because it's filled, unfortunately he will become a homeless :("
        );
    }

    //exhibitors
    public void showPopulationGenotypes() {
        for (int i = 0; i < populationSize; i++) {
            List<Integer> list = Arrays.stream(this.individuals[i].getGenotype())        // IntStream
                    .boxed()        // Stream<Integer>
                    .collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public void showAllIndividuals() {
        for (int i = 0; i < populationSize; i++) {
            this.individuals[i].showInfos();
        }
    }

    public void showPopulationSize() {
        System.out.println("Population size = " + this.populationSize);
    }

    public void showGenotypeSize() {
        System.out.println("Population Genotype size: " + this.individuals[0].getGenotypeSize());
    }

    public void showTotalPopFitness() {
        System.out.println("Total Population Fitness Value: " + this.totalPopulationFitness);
    }

    public void showAveragePopFitness() {
        System.out.println("Average Population Fitness Value: " + this.getAveragePopFitness());
    }

    public void showBestIndividual() {
        System.out.println("Best Individual: ");
        this.bestIndividual.showInfos();
    }

    public void showInfos() {
        System.out.println("###########################################");
        System.out.println("Population information: ");
       //showPopulationGenotypes(); show just genotypes without identification or others information
        //showAllIndividuals();
        showPopulationSize();
        showGenotypeSize();
        showTotalPopFitness();
        showAveragePopFitness();
        showBestIndividual();
        System.out.println("###########################################");
    }

    //generator
    public static Population generateRandomPopulation(final int populationSize, final int genotypeSize) {
        Phenotype[] individuals = generateRandomIndividuals(populationSize, genotypeSize);
        return new Population(populationSize, individuals);
    }

    private static Phenotype[] generateRandomIndividuals(final int populationSize, final int genotypeSize) {
        Phenotype[] individuals = new Phenotype[populationSize];
        for (int i = 0; i < populationSize; i++)
            individuals[i] = Phenotype.generateRandomPhenotype(i, genotypeSize);
        return individuals;
    }
}
