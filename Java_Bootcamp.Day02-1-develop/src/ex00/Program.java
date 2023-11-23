package src.ex00;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class Program {
    private static final String signaturesPath = "/Users/elodiawy/Java/Java_Bootcamp.Day02-1/src/ex00/signatures.txt";
    private static final String resultPath = "/Users/elodiawy/Java/Java_Bootcamp.Day02-1/src/ex00/result.txt";
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Map<String, String> signatures = ReadSignatures.scanSignatures(signaturesPath);
            int i = 0;
            while (true) {
                String filePath = scanner.nextLine();
                if (filePath.equals("42")) {
                    return;
                }
                try (FileOutputStream fileOutputStream = new FileOutputStream(resultPath, true)){
                    String resultScan;
                    resultScan = GetFileType.getFileType(signatures, filePath);
                    if (resultScan != null) {
                        if (i != 0) {
                            fileOutputStream.write("\n".getBytes());
                        }
                        fileOutputStream.write(resultScan.getBytes());
                        System.out.println("PROCESSED");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
