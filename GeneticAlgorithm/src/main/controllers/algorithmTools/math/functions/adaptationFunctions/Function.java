package main.controllers.algorithmTools.math.functions.adaptationFunctions;

public interface Function {
    double calculate(double x, double y);
    String getFuncName();
    void showFuncName();
}
