/***
 * This code was built with the objective of solving problems of 3d greatness
 * Author: Felipe Lodes
 *
 *
 */


package main;

import main.controllers.Handler;

public class GA {

    public static void main(String[] args) {
        //configurable parameters
        int populationSize = 100;
        int endOfTimes = 100;
        double mutationProbability = 0.15;
        double crossoverProbability = 0.85;

        Handler handler = new Handler(populationSize,endOfTimes,mutationProbability,crossoverProbability);
        handler.run();
    }
}
