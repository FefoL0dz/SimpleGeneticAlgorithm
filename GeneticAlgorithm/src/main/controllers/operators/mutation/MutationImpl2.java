package main.controllers.operators.mutation;

import main.controllers.operators.GeneticAlgorithmOperator;
import main.models.pojo.Phenotype;
import main.controllers.algorithmTools.math.conversors.Binary2Decimal;

import java.util.Random;

public class MutationImpl2 implements GeneticAlgorithmOperator, Mutation{
    private double mutationProbability;

    public MutationImpl2(double mutationProbability) {
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
        int x = Binary2Decimal.convertBin2Dec(wolverine.getGenotype(), 0,9);
        int y = Binary2Decimal.convertBin2Dec(wolverine.getGenotype(), 10, 19);

        double X =  generateRandomValue() * x;
        double Y =  generateRandomValue() * y;

        int xVector[] = Binary2Decimal.convertDec2Bin((int) X, 0, 9);
        int yVector[] = Binary2Decimal.convertDec2Bin((int) Y, 10, 19);

        int finalVector[] = new int[20];

        for (int i = 0; i < 10; i++)
            finalVector[i] = xVector[i];
        for (int i = 10; i < 20; i++)
            finalVector[i] = yVector[i-10];

        wolverine.setGenotype(finalVector);

        return wolverine;
    }

    private double generateRandomValue(){
        Random rand = new Random();
        double randomValue = 0.1 + (2.0 - 0.0) * rand.nextDouble();
        return randomValue;
    }


}

