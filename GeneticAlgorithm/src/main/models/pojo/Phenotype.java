package main.models.pojo;

import java.util.Random;

public class Phenotype {

    private int[] genotype;

    private final int id;

    private Double absoluteFitness;

    private Double relativeFitness;

    public Phenotype(int id, int[] genotype) {
        this.id = id;
        this.genotype = genotype;
        this.absoluteFitness = null;
        this.relativeFitness = null;
    }

    //getters
    public int[] getGenotype() {
        return genotype;
    }

    public int getGenotypeSize() {
        return genotype.length;
    }

    public int getId() {
        return id;
    }

    public Double getAbsoluteFitness() { return this.absoluteFitness; }

    public Double getRelativeFitness() { return relativeFitness; }

    //setters
    public void setMutation(int position){
        if(this.genotype[position] == 0)
            this.genotype[position] = 1;
        else
            this.genotype[position] = 0;
    }

    public void setAbsoluteFitness(Double absoluteFitness) { this.absoluteFitness = absoluteFitness; }

    public void setRelativeFitness(Double relativeFitness) {
        this.relativeFitness = relativeFitness;
    }

    public void setGenotype(int[] genotype) {
        this.genotype = genotype;
    }

    //exhibitor
    public void showInfos() {
      System.out.println("Phenotype information :");
      showId();
      showPhenotype();
      showGenotypeSize();
      showAbsoluteFitness();
      showRelativeFitness();
      System.out.println("------------------------------------------------");
    }

    public void showId() {
        System.out.println("Id: " + this.id);
    }

    public void showPhenotype() {
        System.out.print("[");
        for (int i = 0; i < this.genotype.length -1; i++)
            System.out.print(this.genotype[i] + ", ");
        System.out.println(this.genotype[this.genotype.length -1] + "]");
    }

    public void showGenotypeSize() {
        System.out.println("Genotype Size: " + this.genotype.length);
    }

    public void showAbsoluteFitness() {
        System.out.println("Absolute Fitness: " + this.absoluteFitness);
    }

    public void showRelativeFitness() {
        System.out.println("Relative Fitness: " + this.relativeFitness);
    }

    //generator
    public static Phenotype generateRandomPhenotype(int id, int genotypeSize) {
        int[] genotype = generateRandomBinaryGenotype(genotypeSize);
        return new Phenotype(id, genotype);
    }

    private static int[] generateRandomBinaryGenotype(int genotypeSize) {
        int [] randomGenotype = new int[genotypeSize];
        Random random = new Random();
        for (int i = 0; i < genotypeSize; i++)
            randomGenotype[i] = random.nextInt(2);
        return randomGenotype;
    }
}
