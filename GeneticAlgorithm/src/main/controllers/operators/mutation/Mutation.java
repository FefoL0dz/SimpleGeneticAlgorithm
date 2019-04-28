package main.controllers.operators.mutation;

import main.models.pojo.Phenotype;

public interface Mutation {
    double getMutationProbability();
    void setMutationProbability(double mutationProbability);
    void showMutationProbability();
    Phenotype performMutation(Phenotype wolverine);
}
