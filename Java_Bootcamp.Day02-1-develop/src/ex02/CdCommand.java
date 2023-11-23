package src.ex02;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand {
    public static String cd(String currentDirectory, String directoryPath) {
        Path currentDir = Paths.get(currentDirectory).toAbsolutePath();
        Path absolutePath = currentDir.resolve(directoryPath).normalize();
        File newDir = new File(absolutePath.toString());
        if (newDir.exists() && newDir.isDirectory()) {
            System.out.println(newDir.getAbsolutePath());
            return newDir.getAbsolutePath();
        }
        else {
            System.out.println("cd: no such file or directory: " + directoryPath);
        }
        return "./";
    }
}
