package main.controllers.algorithmTools.math.functions.fitnessFunctions;

import main.controllers.algorithmTools.math.functions.adaptationFunctions.Function;

public class FitnessImpl implements Fitness{

    private Function function;

    private final double littleDelt = 0.000001;

    public FitnessImpl(Function function) {
        this.function = function;
    }

    @Override
    public double calculateFitness(double x, double y) {
        double result = 0.0;
        result = 1/(function.calculate(x, y) + littleDelt);
        return result;
    }
}