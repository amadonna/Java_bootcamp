package src.ex03;

import java.io.*;
import java.net.*;

public class DownloadThread  extends Thread{
    private final int fileNumber;
    private final String fileUrl;

    DownloadThread(String fileUrl, int fileNumber) {
        this.fileNumber = fileNumber;
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        int size = 1024;
        try {
            System.out.println(Thread.currentThread().getName() + " start download file number " + fileNumber);
            URI url = new URI(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();
            InputStream inputStream = connection.getInputStream();
            String[] filePart = fileUrl.split("/");
            FileOutputStream outputStream = new FileOutputStream(filePart[filePart.length - 1]);
            byte[] buffer = new byte[size];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();
            System.out.println(Thread.currentThread().getName() + " finish download file number " + fileNumber);
        }
        catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
