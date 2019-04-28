package main.controllers.algorithmTools.croupiers;

/**
 * This Class will not be used anymore....
 */

@Deprecated
public class Roulette {
    private double mutationProbability;

    private double crossoverProbability;

    public Roulette(double mutationProbability, double crossoverProbability) {
        this.mutationProbability = mutationProbability;
        this.crossoverProbability = crossoverProbability;
    }

    //getters

    public double getMutationProbability() {
        return mutationProbability;
    }

    public double getCrossoverProbability() {
        return crossoverProbability;
    }

    //setters

    public void setMutationProbability(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public void setCrossoverProbability(double crossoverProbability) {
        this.crossoverProbability = crossoverProbability;
    }

    //exhibitor

    public void showMutationProbability() { System.out.println("MutationImpl probability = " + this.mutationProbability); }

    public void showCrossoverProbability() { System.out.println("CrossoverImpl probability = " + this.crossoverProbability); }

    public void showInfos() {
        System.out.println("Roulette information :");
        showMutationProbability();
        showCrossoverProbability();
        System.out.println("------------------------------------------------");
    }
}
