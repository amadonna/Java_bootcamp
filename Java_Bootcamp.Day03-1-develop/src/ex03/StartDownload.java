package src.ex03;

import java.util.ArrayList;
import java.util.List;

public class StartDownload {
    public static void download(ArrayList<String> urls, int count) throws InterruptedException {
        List<DownloadThread> threads = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            for (int j = 0; j < count && (i + j < urls.size()); j++) {
                DownloadThread downloadThread = new DownloadThread(urls.get(i + j), i + j + 1);
                downloadThread.start();
                threads.add(downloadThread);
            }
            for (DownloadThread t : threads) {
                t.join();
            }
        }
    }
}
