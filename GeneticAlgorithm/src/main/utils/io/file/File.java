package main.utils.io.file;

import main.utils.io.folder.FolderNamesList;

public abstract class File {
    protected String name;
    protected String extension;
    protected String path;

    public File(String name, String extension) {
        this.name = name;
        this.extension = extension;
        this.path = FolderNamesList.ROOT_PATH + "\\" + name + extension;
    }

    public abstract void createFile();
}
