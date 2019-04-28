package main.utils.analytics.analyticsDataModel;

public class ProblemConfigurationData extends Data {
    private String popSize;
    private String numberOfRepBits;
    private String genotypeSize;
    private String endOfTimes;
    private String mutationProb;
    private String crossoverProb;
    private String function;
    private String minVar;
    private String maxVar;
    private String dimensionalSpace;
    private String elitism;
    private String thresholdRate;
    private String mutationIncRate;
    private String currentTime;

    public String getPopSize() {
        return popSize;
    }

    public String getNumberOfRepBits() {
        return numberOfRepBits;
    }

    public String getGenotypeSize() {
        return genotypeSize;
    }

    public String getEndOfTimes() {
        return endOfTimes;
    }

    public String getMutationProb() {
        return mutationProb;
    }

    public String getCrossoverProb() {
        return crossoverProb;
    }

    public String getFunction() {
        return function;
    }

    public String getMinVar() {
        return minVar;
    }

    public String getMaxVar() {
        return maxVar;
    }

    public String getDimensionalSpace() {
        return dimensionalSpace;
    }

    public String getEletism() {
        return elitism;
    }

    public String getThresholdRate() {
        return thresholdRate;
    }

    public String getMutationIncRate() {
        return mutationIncRate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getPopSizeLabel() {
        return "populationSize";
    }

    public String getNumberOfRepBitsLabel() {
        return "numberOfRepresentationBits";
    }

    public String getGenotypeSizeLabel() {
        return "genotypeSize";
    }

    public String getEndOfTimesLabel() {
        return "endOfTimes";
    }

    public String getMutationProbLabel() {
        return "mutationProbability";
    }

    public String getCrossoverProbLabel() {
        return "crossoverProbability";
    }

    public String getFunctionLabel() {
        return "function";
    }

    public String getMinVarLabel() {
        return "minValue";
    }

    public String getMaxVarLabel() {
        return "maxValue";
    }

    public String getDimensionalSpaceLabel() {
        return "dimensionalSpace";
    }

    public String getEletismLabel() {
        return "elitism";
    }

    public String getThresholdRateLabel() {
        return "threshold";
    }

    public String getMutationIncRateLabel() {
        return "mutationIncreaseRate";
    }

    public String getCurrentTimeLabel() {
        return "currentTime";
    }

    public ProblemConfigurationData
            (String popSize,
             String numberOfRepBits,
             String genotypeSize,
             String endOfTimes,
             String mutationProb,
             String crossoverProb,
             String function,
             String minVar,
             String maxVar,
             String dimensionalSpace,
             String elitism,
             String thresholdRate,
             String mutationIncRate,
             String currentTime)
    {
        this.popSize = popSize;
        this.numberOfRepBits = numberOfRepBits;
        this.genotypeSize = genotypeSize;
        this.endOfTimes = endOfTimes;
        this.mutationProb = mutationProb;
        this.crossoverProb = crossoverProb;
        this.function = function;
        this.minVar = minVar;
        this.maxVar = maxVar;
        this.dimensionalSpace = dimensionalSpace;
        this.elitism = elitism;
        this.thresholdRate = thresholdRate;
        this.mutationIncRate = mutationIncRate;
        this.currentTime = currentTime;
    }
}
