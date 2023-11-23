package src.ex02;

import java.io.File;

public class GetDirectorySize {
    public static long size(File directory) {
        long size = 0;
        File [] files = directory.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    size += f.length();
                }
                else if (f.isDirectory()) {
                    size += size(f);
                }
            }
        }
        return size;
    }
}
