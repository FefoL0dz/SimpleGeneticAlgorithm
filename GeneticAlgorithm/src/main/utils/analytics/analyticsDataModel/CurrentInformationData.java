package main.utils.analytics.analyticsDataModel;

public class CurrentInformationData  extends  Data {
   // private IndividualsListData popListData;

    private String currentEpoch;
    private String time;
    private String crossProb;
    private String mutProb;
    private String totalPopFitness;
    private String averagePopFitness;
    private String bestPhenotypeId;
    private String bestPhenotypeGenotype;
    private String bestPhenotypeAbsFitness;
    private String bestPhenotypeRelFitness;

   // public IndividualsListData getPopListData() {return popListData; }

    public String getCurrentEpoch() {
        return currentEpoch;
    }

    public String getTime() {
        return time;
    }

    public String getCrossProb() {
        return crossProb;
    }

    public String getMutProb() {
        return mutProb;
    }

    public String getTotalPopFitness() {
        return totalPopFitness;
    }

    public String getAveragePopFitness() {
        return averagePopFitness;
    }

    public String getBestPhenotypeId() {
        return bestPhenotypeId;
    }

    public String getBestPhenotypeGenotype() {
        return bestPhenotypeGenotype;
    }

    public String getBestPhenotypeAbsFitness() {
        return bestPhenotypeAbsFitness;
    }

    public String getBestPhenotypeRelFitness() {
        return bestPhenotypeRelFitness;
    }

    public String getCurrentEpochLabel() {
        return "currentEpoch";
    }

    public String getTimeLabel() {
        return "time";
    }

    public String getCrossProbLabel() {
        return "crossProb";
    }

    public String getMutProbLabel() {
        return "mutProb";
    }

    public String getTotalPopFitnessLabel() {
        return "totalPopFitness";
    }

    public String getAveragePopFitnessLabel() {
        return "averagePopFitness";
    }

    public String getBestPhenotypeIdLabel() {
        return "bestPhenotypeId";
    }

    public String getBestPhenotypeGenotypeLabel() {
        return "bestPhenotypeGenotype";
    }

    public String getBestPhenotypeAbsFitnessLabel() {
        return "bestPhenotypeAbsFitness";
    }

    public String getBestPhenotypeRelFitnessLabel() {
        return "bestPhenotypeRelFitness";
    }

    public CurrentInformationData(String currentEpoch,
                                  String time,
                                  String crossProb,
                                  String mutProb,
                                  String totalPopFitness,
                                  String averagePopFitness,
                                  String bestPhenotypeId,
                                  String bestPhenotypeGenotype,
                                  String bestPhenotypeAbsFitness,
                                  String bestPhenotypeRelFitness)
    {
        super();
        this.currentEpoch = currentEpoch;
        this.time = time;
        this.crossProb = crossProb;
        this.mutProb = mutProb;
        this.totalPopFitness = totalPopFitness;
        this.averagePopFitness = averagePopFitness;
        this.bestPhenotypeId = bestPhenotypeId;
        this.bestPhenotypeGenotype = bestPhenotypeGenotype;
        this.bestPhenotypeAbsFitness = bestPhenotypeAbsFitness;
        this.bestPhenotypeRelFitness = bestPhenotypeRelFitness;
    }

   @Deprecated
   public class IndividualsListData extends Data{
        String[][] individualsList;

        public IndividualsListData(String[][] individualsList) {
            this.individualsList = individualsList;
        }

        public String[][] getIndividualsList() {
            return individualsList;
        }

        public String getIndividualId(int index) {
            return this.individualsList[index][0];
        }

        public String getIndividualGenotype(int index) {
            return this.individualsList[index][1];
        }

        public String getIndividualAbsFitness(int index) {
            return this.individualsList[index][2];
        }

        public String getIndividualRelFitness(int index) {
            return this.individualsList[index][3];
        }

        public String getIndividualIdLabel() {
            return "IndividualId";
        }

        public String getIndividualGenotypeLabel() {
            return "IndividualGenotype";
        }

        public String getIndividualAbsFitnessLabel() {
            return "IndividualAbsFitness";
        }

        public String getIndividualRelFitnessLabel() {
            return "IndividualRelFitness";
        }
    }
}
