package http_server_app.server.Directory;

import java.io.File;
import java.util.ArrayList;

public class Directory {
  public static ArrayList<File> getFiles(File directory) {
  ArrayList<File> files = new ArrayList<>();
    File[] filesList = directory.listFiles();
    if (filesList != null) {
      for (File file : filesList) {
          files.add(file);
      }
    }
    return files;
  }
}
