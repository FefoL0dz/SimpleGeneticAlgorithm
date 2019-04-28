package main.controllers.algorithmTools.math.variation;

public class Variation {

    private double variableMin;

    private double variableMax;

    private int numberOfRepresentationBits; //TODO: see if the variable used it's numberOfRepresentationBits or populationSize

    private double q; // this variable represents the normalization factor

    public Variation(double min, double max, int numberOfRepresentationBits) {
        this.variableMax = max;
        this.variableMin = min;
        this.numberOfRepresentationBits = numberOfRepresentationBits;
        calculateNormalizationConstant();
    }

    private void calculateNormalizationConstant() {
        q = (variableMax - variableMin)/( Math.pow(2, numberOfRepresentationBits) -1);
    }

    public double getNormalizedValue(int genotypeValue) {
        double result;
        result = (genotypeValue * q) + variableMin;
        return result;
    }

    //exhibitors
    public void showFactor() {
        System.out.println("Factor: " + q);
    }

    public void showMinValue() {
        System.out.println("Min variable: " + this.variableMin);
    }

    public void showMaxValue() {
        System.out.println("Max variable: " + this.variableMax);
    }

    public void showNumberOfRepresentationBits() {
        System.out.println("Number Of Representation Bits: " + this.numberOfRepresentationBits);
    }

    public void showInfos() {
        System.out.println("---------------");
        System.out.println("Variation information: ");
        showNumberOfRepresentationBits();
        showMaxValue();
        showMinValue();
        showFactor();
        System.out.println("---------------");
    }

}