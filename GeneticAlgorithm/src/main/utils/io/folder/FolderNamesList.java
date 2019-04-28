package main.utils.io.folder;

public class FolderNamesList {
    public static final String disk = "d:\\";

    private static final String ROOT_FOLDER = "GeneticAlgorithmLogs";
    public static String ROOT_PATH = disk + ROOT_FOLDER + "\\";
    public static final String ROOT_PATH_ORIGIN = disk + ROOT_FOLDER + "\\";

    private static final String INDIVIDUALS_FOLDER = "Individuals";
    public static final String INDIVIDUALS_PATH = ROOT_PATH + "\\" + INDIVIDUALS_FOLDER;

    public static void updateRootPath(String folderName) {
        ROOT_PATH = ROOT_PATH_ORIGIN;
        ROOT_PATH += folderName;
    }
}
