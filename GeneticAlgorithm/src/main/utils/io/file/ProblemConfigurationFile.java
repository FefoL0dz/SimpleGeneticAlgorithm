package main.utils.io.file;

import main.utils.analytics.analyticsDataModel.ProblemConfigurationData;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemConfigurationFile extends File {
    public ProblemConfigurationFile(String name, String extension) {
        super(name, extension);
    }

    ProblemConfigurationData data;
    public void setData(ProblemConfigurationData data) {
        this.data = data;
    }

    @Override
    public void createFile() {
        try{
            FileWriter fw = new FileWriter(this.path, true);
            PrintWriter writer = new PrintWriter(fw);

            String splitter = ": ";

            writer.append(data.getPopSizeLabel());
            writer.append(splitter);
            writer.append(data.getPopSize());
            writer.println();

            writer.append(data.getEndOfTimesLabel());
            writer.append(splitter);
            writer.append(data.getEndOfTimes());
            writer.println();

            writer.append(data.getCrossoverProbLabel());
            writer.append(splitter);
            writer.append(data.getCrossoverProb());
            writer.println();

            writer.append(data.getMutationProbLabel());
            writer.append(splitter);
            writer.append(data.getMutationProb());
            writer.println();

            writer.append(data.getFunctionLabel());
            writer.append(splitter);
            writer.append(data.getFunction());
            writer.println();

            writer.append(data.getGenotypeSizeLabel());
            writer.append(splitter);
            writer.append(data.getGenotypeSize());
            writer.println();

            writer.append(data.getFunctionLabel());
            writer.append(splitter);
            writer.append(data.getFunction());
            writer.println();

            writer.append(data.getDimensionalSpaceLabel());
            writer.append(splitter);
            writer.append(data.getDimensionalSpace());
            writer.println();

            writer.append(data.getNumberOfRepBitsLabel());
            writer.append(splitter);
            writer.append(data.getNumberOfRepBits());
            writer.println();

            writer.append(data.getEletismLabel());
            writer.append(splitter);
            writer.append(data.getEletism());
            writer.println();

            writer.append(data.getThresholdRateLabel());
            writer.append(splitter);
            writer.append(data.getThresholdRate());
            writer.println();

            writer.append(data.getMaxVarLabel());
            writer.append(splitter);
            writer.append(data.getMaxVar());
            writer.println();

            writer.append(data.getMinVarLabel());
            writer.append(splitter);
            writer.append(data.getMinVar());
            writer.println();

            writer.append(data.getMutationIncRateLabel());
            writer.append(splitter);
            writer.append(data.getMutationIncRate());
            writer.println();

           /* writer.append(data.getCurrentTimeLabel());
            writer.append(splitter);
            writer.append(data.getCurrentTime());
            writer.println();*/

            writer.flush();
            writer.close();

            fw.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Impossible to create the File: " + path);
        }
    }

}
