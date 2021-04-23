package so.downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java/47598360#47598360
 */
public class Application {
    public static void main(String[] args) throws MalformedURLException, IOException {
        if (2 != args.length) {
            System.out.println(String.format("USAGE: java -jar so-downloader.jar <source-URL> <target-filename>"));
            System.exit(1);
        }

        String sourceUrl = args[0];
        String targetFilename = args[1];

        long bytesDownloaded = download(sourceUrl, targetFilename);

        String message = String.format("Downloaded %d bytes from %s to %s.", bytesDownloaded, sourceUrl, targetFilename);

        System.out.println(message);
    }

    // package scope to allow test class to access
    static long download(String sourceUrl, String targetFileName) throws MalformedURLException, IOException {
        try (InputStream in = URI.create(sourceUrl).toURL().openStream()) {
            return Files.copy(in, Paths.get(targetFileName));
        }
    }

}
