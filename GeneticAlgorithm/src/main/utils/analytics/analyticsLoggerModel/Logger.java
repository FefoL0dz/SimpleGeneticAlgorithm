package main.utils.analytics.analyticsLoggerModel;

import main.utils.analytics.analyticsDataModel.CurrentInformationData;
import main.utils.analytics.analyticsDataModel.ProblemConfigurationData;
import main.utils.io.file.*;
import main.utils.io.folder.Folder;
import main.utils.io.folder.FolderNamesList;

public class Logger {
    private CurrentInformationFile informationFile;
    private ProblemConfigurationFile  configFile;
    private int executionNumber;

    public Logger() {
        executionNumber = 1;

        FolderNamesList.updateRootPath(String.valueOf(executionNumber));

        while(Folder.isFolderAlreadyCreated(FolderNamesList.ROOT_PATH)) {
            executionNumber++;
            FolderNamesList.updateRootPath(String.valueOf(executionNumber));
        }

        Folder.createFolder(FolderNamesList.ROOT_PATH);

        String extension = FileExtensionsList.TXT;
        configFile = new ProblemConfigurationFile(FileNamesList.MAIN_LOG, extension);
    }

    public void log (CurrentInformationData data) {
        String infoFileName = FileNamesList.CURRENT_EPOCH_INFORMATION ;

        String extension = FileExtensionsList.CSV;

        informationFile = new CurrentInformationFile(infoFileName, extension);

        informationFile.setData(data);

        informationFile.createFile();
    }

    public void initialLog(ProblemConfigurationData data) {
        this.configFile.setData(data);
        this.configFile.createFile();
    }

}
