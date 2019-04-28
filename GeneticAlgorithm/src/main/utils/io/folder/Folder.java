package main.utils.io.folder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder {
    public static void createFolder(String folderPath) throws IllegalArgumentException{
        String completeFolderPath = folderPath + "\\";

        if(isFolderAlreadyCreated(completeFolderPath))
            throw new IllegalArgumentException("This folder already exists and cannot be created: " + completeFolderPath);

        boolean success = (new File(completeFolderPath)).mkdirs();
        if (!success)
            throw new IllegalArgumentException("Error occurred during folder creating: " + completeFolderPath);
    }

    public static boolean isFolderAlreadyCreated(String file) {
        Path p = Paths.get(file);
        boolean exists = Files.exists(p);
        return exists;
    }
}
