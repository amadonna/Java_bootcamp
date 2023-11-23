package src.ex02;

import java.io.File;

public class LsCommand {
    public static void list(String directoryPath) {
        File [] files = new File(directoryPath).listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.print(f.getName() + "\t");
                if (f.isFile()) {
                    System.out.println(f.length() / 1024 + "\tKb");
                } else if (f.isDirectory()) {
                    System.out.println(GetDirectorySize.size(f) / 1024 + "\tKb");
                }
            }
        }
    }
}
