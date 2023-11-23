package src.ex02;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFile {
    public static void mv(String fileName, String directory, String currentDir) {
        File src = new File(currentDir, fileName);
        File dstDirect = new File(currentDir, directory);
        if (src.exists() && dstDirect.exists() && dstDirect.isDirectory()) {
            Path srcPath = src.toPath();
            Path dstPath = dstDirect.toPath().resolve(src.getName());
            try {
                Files.move(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else  {
            System.out.println("cd: no such file or directory: " + fileName + " or " + directory);
        }
    }
}
