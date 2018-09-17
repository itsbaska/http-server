package server.Directory;

import http_server_app.server.Directory.FileHandler;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

  @Test
  public void getFileExtension() {
    File file = null;
    File dir = Paths.get(".", "src", "test", "java", "temp").toFile();

    try {
      file = File.createTempFile("JavaTemp", ".txt", dir);
    } catch (IOException e) {
      System.out.println(e);
    }

    FileHandler fileHandler = new FileHandler(file);
    assertEquals("txt", fileHandler.getFileExtension());
  }

  @Test
  public void getFileExtensionWhenNoExtension() {
    File file = null;
    File dir = Paths.get(".", "src", "test", "java", "temp").toFile();

    try {
      file = File.createTempFile("JavaTemp", "", dir);
    } catch (IOException e) {
      System.out.println(e);
    }

    FileHandler fileHandler = new FileHandler(file);
    assertEquals("", fileHandler.getFileExtension());
  }
}
