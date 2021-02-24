package so.downloader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

public class ApplicationTest {
	@Test
	public void downloadFile() throws MalformedURLException, IOException {
		assertThat(Application.download("https://github.com/JanStureNielsen/so-downloader/archive/main.zip", "so-downloader-source.zip")).isNotZero();
	}

	@Test
	public void illegalArgument() throws MalformedURLException, IOException {
		assertThrows(IllegalArgumentException.class, () -> Application.download("this-is-not-a-url", "some-file"));
	}

	@Test
	public void fileNotFound() throws MalformedURLException, IOException {
		assertThrows(FileNotFoundException.class, () -> Application.download("file:///this-is-not-found", "some-file"));
	}

	@Test
	public void malformedUrl() throws MalformedURLException, IOException {
		assertThrows(MalformedURLException.class, () -> Application.download("protocol-invalid:///this-is-not-found", "some-file"));
	}

}
