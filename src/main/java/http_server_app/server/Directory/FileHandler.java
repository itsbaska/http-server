package http_server_app.server.Directory;

import http_server_app.application.controller.Handler.Handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler extends Handler {

  private final File file;

  public FileHandler(File file) {
    this.file = file;
  }

  public String getFileExtension() {
    String fileName = this.file.getName();
    String extension = "";
    if (fileName.split("\\.").length > 1) {
      extension = fileName.split("\\.")[1];
    }
    return extension;
  }

  public void updateContent(String text) {
    try {
      FileWriter writer = new FileWriter(file);
      writer.write(text);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addContent(String text) {
    try {
      FileWriter writer = new FileWriter(file, true);
      writer.write(text);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public byte[] readContent() {
    byte[] content = new byte[0];
    try {
      content = Files.readAllBytes(Paths.get(file.getPath()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }
}
