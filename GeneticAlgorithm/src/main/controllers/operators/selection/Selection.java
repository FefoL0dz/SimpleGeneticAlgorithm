package main.controllers.operators.selection;

import main.controllers.operators.crossover.Crossover;
import main.controllers.operators.mutation.Mutation;
import main.models.pojo.Population;

public interface Selection {
    Mutation getMutationOperator();
    void setMutationOperator(Mutation mutationOperator);
    void setCrossoverOperator(Crossover crossoverOperator);
    Crossover getCrossoverOperator();
    Population selectIndividuals(Population oldPopulation, Population newPopulation, int offset);
}
