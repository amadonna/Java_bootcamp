package src.ex02;

import java.io.File;

public class MvCommand {
    public static void move(String src, String fileOrDirect, String currentDir) {
        File dst = new File(currentDir, fileOrDirect);
        if (dst.exists() && dst.isDirectory()) {
            MoveFile.mv(src, fileOrDirect, currentDir);
        }
        else {
            RenameFile.rename(src, fileOrDirect, currentDir);
        }
    }
}
