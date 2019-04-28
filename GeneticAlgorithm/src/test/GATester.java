package test;

import main.controllers.Handler;
import main.controllers.algorithmTools.math.functions.adaptationFunctions.Rastrigins3D;
import main.controllers.algorithmTools.math.functions.fitnessFunctions.FitnessImpl;
import main.controllers.algorithmTools.math.variation.Variation;
import main.models.pojo.Phenotype;
import main.models.pojo.Population;
import main.controllers.algorithmTools.math.conversors.Binary2Decimal;
import main.utils.clock.*;

import java.util.Random;
public class GATester {
    int populationSize = 600;
    int endOfTimes =100;
    int numberOfBitsRepresentation = 10;
    double minVariable = -5.12;
    double maxVariable = 5.12;
    double mutationProbability = 0.30;
    double crossoverProbability = 0.80;
    Handler handler;

    //11h24
    public static void main(String[] args) {
        Timer clock = new Timer();
        System.out.println("Hello World!");
        GATester t = new GATester();
        t.initializeHandler();
        t.normalTestGettingBestIndividual();
        //t.testeOverffiting();
        //randomPopulationTest();
        //bin2DecTest();
        //findBestIndividualTest();
        //randomTest();
       // t.testConversionDec2Bin();
        //while(true)
        //t.runRouletteWheel();
        clock.refreshTime();
        clock.printTotalTime();
    }

    private void testeOverffiting() {
        int[] fenotipo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int x = Binary2Decimal //going until half of vector
                .convertBin2Dec(fenotipo, 0, 9);

        int y = Binary2Decimal //going from half until end of vector
                .convertBin2Dec(fenotipo, 10, 19);

        Variation q = new Variation(this.minVariable, this.maxVariable, this.numberOfBitsRepresentation);

        double X = q.getNormalizedValue(x);
        double Y = q.getNormalizedValue(y);

        FitnessImpl fitnessFunc = new FitnessImpl(new Rastrigins3D());

        double absoluteFitness = fitnessFunc.calculateFitness(X , Y);

        System.out.println(x);
        System.out.println(y);
        System.out.println(X);
        System.out.println(Y);
        System.out.println(absoluteFitness);
    }

    private void testConversionDec2Bin() {
        int x = 12;
        int[] test = Binary2Decimal.convertDec2Bin(x, 0, 9);
        System.out.print("[");
        for (int i = 0; i < test.length - 1; i++) {
            System.out.print(test[i]+ ", ");
        }
        System.out.println(test[test.length - 1] + "]");
    }

    private void runRouletteWheel() {
        Random rand = new Random();
        double randomValue = 0.0 + (1.0 - 0.0) * rand.nextDouble();
        System.out.println(randomValue);
    }

    private void initializeHandler() {
         handler = new Handler(populationSize, endOfTimes, mutationProbability, crossoverProbability);
    }

    private void normalTestGettingBestIndividual() {
        // Handler.startAlgorithm(populationSize, endOfTimes, mutationProbability, crossoverProbability);
        Phenotype b = handler.runGettingBestIndividual();
        b.showInfos();
    }

    private void normalTest() {
       // Handler.startAlgorithm(populationSize, endOfTimes, mutationProbability, crossoverProbability);
        handler.run();
    }

    private static void findBestIndividualTest() {
        int populationSize = 100;
        int endOfTimes = 100;
        int genotypeSize = 10;
        double minVariable = -5.12;
        double maxVariable = 5.12;
        double mutationProbability = 0.15;
        double crossoverProbability = 0.85;

       //Phenotype bestIndividual = Handler
              // .startAlgorithm(populationSize, endOfTimes, mutationProbability, crossoverProbability);

      // if(bestIndividual == null) System.out.println("NULL");
      // else System.out.println("Find Someone here!");
    }

    private static void bin2DecTest() {
        int[] vector = {1,1,0,1,1,1,1,1,1,1};
        int result = Binary2Decimal.convertBin2Dec(vector, 0, 9);
        System.out.println(result);
    }

    private static void randomPopulationTest() {
        Population pop = new Population(100);
        pop.setRandomPopulation(20);
        pop.showAllIndividuals();
    }
}
