package main.controllers;

import main.controllers.algorithmTools.math.functions.adaptationFunctions.Function;
import main.controllers.algorithmTools.math.functions.adaptationFunctions.Rastrigins3D;
import main.controllers.algorithmTools.math.variation.Variation;

/**
 *  This Class was created to set an immutable default GA configuration.
 *  This set of values shouldn't be modified to solve the EP problem, except for the objective to solve other generic problem.
 */

public class HandlerConfigFile {

    protected final int DIMENSIONAL_SPACE = 3;

    protected final Function function= new Rastrigins3D();

    protected final double minVariable = -5.0; //-5.12;

    protected final double maxVariable = 5.0; //5.12;

    protected final int numberOfRepresentationBits = 10;

    protected final Variation q = new Variation(minVariable, maxVariable, numberOfRepresentationBits);

    protected final boolean elitism = false;

    protected final double threshold = 0.30;

    protected int timesMutationWasIncreased = 0;

    protected double mutationIncreaseRate = 0.3;

    protected boolean loggerEnable = true;

    //exhibitors
    protected void showDefaultConfigInfos() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Default Configurations: ");
        showDimensionalSpace();
        showUsedFunction();
        showQ();
        showBelief();
        showMutationIncreaseRate();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

    protected void showDimensionalSpace() {
        System.out.println("Dimensional Space: " + this.DIMENSIONAL_SPACE);
    }

    protected void showUsedFunction() {
        this.function.showFuncName();
    }

    protected void showQ() { this.q.showInfos(); }

    protected void showBelief() {
        System.out.print("Population belief: ");
        if(elitism) System.out.println("Elitism");
        else System.out.println("Meritocracy");
    }

    protected void showMutationIncreaseRate() {
        System.out.println("Rate of mutation increase: " + this.mutationIncreaseRate * 100 + "%");
    }

}
