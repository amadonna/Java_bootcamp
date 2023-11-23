package src.ex02;

import java.io.File;

public class RenameFile {
    public static void rename(String oldName, String newName, String currentDir) {
        File oldFile = new File(currentDir, oldName);
        File newFile = new File(currentDir, newName);
        if (oldFile.exists() && oldFile.isFile()) {
            if (!oldFile.renameTo(newFile)) {
                System.out.println("didn't rename");
            }
        }
        else {
            System.out.println("no such file or directory: " + "'"+oldName+"'");
        }
    }

}
