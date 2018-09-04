package Directory;

import Router.Handler.Handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler extends Handler {

  private final File file;

  public FileHandler(File file) {
    this.file = file;
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

  public void deleteContent() {
    FileWriter writer = null;
    try {
      writer = new FileWriter(file);
      writer.write("");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String toHtmlList() {
    String content = new String(readContent());
    ArrayList<String> list = new ArrayList<>(Arrays.asList(content.split("\\n")));
    return Formatter.list(list);
  }
}
