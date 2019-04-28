package main.utils.io.file;

import main.utils.analytics.analyticsDataModel.CurrentInformationData;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Deprecated
public class IndividualsListFile extends File {
    public IndividualsListFile(String name, String extension) {
        super(name, extension);
    }

    CurrentInformationData.IndividualsListData data;
    public void setData(CurrentInformationData.IndividualsListData data) {
        this.data = data;
    }

    @Override
    public void createFile() {
    }
}
