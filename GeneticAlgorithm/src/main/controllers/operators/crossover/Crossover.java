package main.controllers.operators.crossover;

import main.models.pojo.Phenotype;

public interface Crossover {
    double getCrossoverProbability();
    void setCrossoverProbability(double crossoverProbability);
    void showCrossoverProbability();
    Phenotype performCrossover(Phenotype individual1, Phenotype individual2, int id);
}
