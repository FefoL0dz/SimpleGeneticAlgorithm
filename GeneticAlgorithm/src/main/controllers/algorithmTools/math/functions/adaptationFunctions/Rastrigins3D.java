package main.controllers.algorithmTools.math.functions.adaptationFunctions;

public class Rastrigins3D implements Function {

    public final String FUNC_NAME = "Rastrings3D";

    @Override
    public double calculate(double x, double y) {
        double result = 20 + Math.pow(x, 2) + Math.pow(y, 2) - (10 * cosineSum(x,y));
        return result;
    }

    private double cosineSum(double x, double y) {
        // TODO Auto-generated method stub
        return Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y);
    }

    @Override
    public String getFuncName() {
        return this.FUNC_NAME;
    }

    @Override
    public void showFuncName() {
        System.out.println("Function name: " + this.FUNC_NAME);
    }

}
