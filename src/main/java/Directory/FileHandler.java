package Directory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {

  private final File file;

  public FileHandler(File file) {
    this.file = file;

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
      content =  Files.readAllBytes(Paths.get(file.getPath()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  public void deleteContent() throws IOException {
    FileWriter writer = new FileWriter(file, true);
    writer.write("");
    writer.close();
  }

  public String toHtmlList() {
    String content = new String(readContent());
    ArrayList<String> list = new ArrayList<>(Arrays.asList(content.split("\\n")));
    return Formatter.list(list);
  }
}
