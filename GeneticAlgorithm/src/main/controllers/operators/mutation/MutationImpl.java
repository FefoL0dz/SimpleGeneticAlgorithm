package main.controllers.operators.mutation;

import main.controllers.operators.GeneticAlgorithmOperator;
import main.models.pojo.Phenotype;

import java.util.Random;

public class MutationImpl implements GeneticAlgorithmOperator, Mutation{
    private double mutationProbability;

    public MutationImpl(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    @Override
    public double getMutationProbability() {
        return mutationProbability;
    }

    @Override
    public void setMutationProbability(double mutationProbability) {
        if(mutationProbability <= 1 && mutationProbability >= 0)
        this.mutationProbability = mutationProbability;
    }

    @Override
    public void showMutationProbability() { System.out.println("MutationImpl probability: " + 100 * this.mutationProbability + "%"); }

    @Override
    public Phenotype performMutation(Phenotype wolverine) {
        for (int i = 0; i < wolverine.getGenotypeSize(); i++) {
            if(generateRandomValue() <= this.mutationProbability)
                wolverine.setMutation(i);
        }
        return wolverine;
    }

    private double generateRandomValue(){
        Random rand = new Random();
        double randomValue = 0.0 + (1.0 - 0.0) * rand.nextDouble();
        return randomValue;
    }
}
