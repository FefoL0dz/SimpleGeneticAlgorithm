package main.controllers.operators.crossover;

import main.controllers.operators.GeneticAlgorithmOperator;
import main.models.pojo.Phenotype;

public class CrossoverImpl implements GeneticAlgorithmOperator, Crossover {
    private double crossoverProbability;

    public CrossoverImpl(double crossoverProbability) {
        this.crossoverProbability = crossoverProbability;
    }

    @Override
    public double getCrossoverProbability() {
        return crossoverProbability;
    }

    @Override
    public void setCrossoverProbability(double crossoverProbability) {
        if(crossoverProbability >= 0 && crossoverProbability <= 1)
        this.crossoverProbability = crossoverProbability;
    }

    @Override
    public void showCrossoverProbability() { System.out.println("CrossoverImpl probability: " + 100 * this.crossoverProbability +"%"); }

    @Override
    public Phenotype performCrossover(Phenotype individual1, Phenotype individual2, int id) {
        int[] genotype = new int[individual1.getGenotypeSize()];
        int i = 0;

        for (; i < individual2.getGenotypeSize()/2; i++) {
            genotype[i] = individual1.getGenotype()[i];
        }
        for (; i < individual2.getGenotypeSize(); i++) {
            genotype[i] = individual2.getGenotype()[i];
        }
        return new Phenotype(id, genotype);
    }
}
