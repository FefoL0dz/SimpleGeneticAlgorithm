package main.utils.io.file;

import main.utils.analytics.analyticsDataModel.CurrentInformationData;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CurrentInformationFile extends File {
    public CurrentInformationFile(String name, String extension) {
        super(name, extension);
    }

    CurrentInformationData data;
    public void setData(CurrentInformationData data) {this.data = data;}

    @Override
    public void createFile() {
        java.io.File log = new java.io.File(this.path);
        try{
            //TODO: see if i dont need to verify if file already exists
            FileWriter wf = new FileWriter(this.path, true);
            PrintWriter wp = new PrintWriter(wf);

            String splitter = ",";

            if(new java.io.File(this.path).exists()) {
                wp.append(data.getCurrentEpochLabel());
                wp.append(splitter);

                wp.append(data.getBestPhenotypeIdLabel());
                wp.append(splitter);

                wp.append(data.getBestPhenotypeGenotypeLabel());
                wp.append(splitter);

                wp.append(data.getBestPhenotypeAbsFitnessLabel());
                wp.append(splitter);

                wp.append(data.getBestPhenotypeRelFitnessLabel());
                wp.append(splitter);

                wp.append(data.getTotalPopFitnessLabel());
                wp.append(splitter);

                wp.append(data.getAveragePopFitnessLabel());
                wp.append(splitter);

                wp.append(data.getMutProbLabel());
                wp.append(splitter);

                wp.append(data.getCrossProbLabel());
                wp.append(splitter);

                wp.println();
            }

            wp.append(data.getCurrentEpoch());
            wp.append(splitter);

            wp.append(data.getBestPhenotypeId());
            wp.append(splitter);

            wp.append(data.getBestPhenotypeGenotype());
            wp.append(splitter);

            wp.append(data.getBestPhenotypeAbsFitness());
            wp.append(splitter);

            wp.append(data.getBestPhenotypeRelFitness());
            wp.append(splitter);

            wp.append(data.getTotalPopFitness());
            wp.append(splitter);

            wp.append(data.getAveragePopFitness());
            wp.append(splitter);

            wp.append(data.getMutProb());
            wp.append(splitter);

            wp.append(data.getCrossProb());
            wp.append(splitter);

            wp.println();

            wp.flush();
            wp.close();

            wf.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Impossible to create the File: " + path);
        }
    }
}
