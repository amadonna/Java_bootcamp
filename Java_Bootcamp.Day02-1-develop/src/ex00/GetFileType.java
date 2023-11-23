package src.ex00;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class GetFileType {
    public static String getFileType(Map<String, String> signatures, String pathFile) {
        try (FileInputStream fileInputStream = new FileInputStream(pathFile)) {
            int i = 0;
            StringBuilder hexHead = new StringBuilder();
            while (i < 15) {
                byte[] headBytes = new byte[1];
                if ( fileInputStream.read(headBytes) != 1) {
                    return null;
                }
                for (byte b : headBytes) {
                    hexHead.append(String.format("%02X", b));
                }
                String fileType = signatures.get(hexHead.toString());
                if (fileType != null) {
                    return fileType;
                }
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
