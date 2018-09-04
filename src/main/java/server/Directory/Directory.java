package server.Directory;

import java.io.File;
import java.util.ArrayList;

public class Directory {
  private final File directory;

  public Directory(File directory) {
    this.directory = directory;
  }

  public ArrayList<String> getFileNames() {
    ArrayList<String> fileName = new ArrayList<>();
    File[] listOfFiles = directory.listFiles();

    if (listOfFiles != null) {
      for (File file : listOfFiles) {
        if (file.isFile() || file.isDirectory()) {
          fileName.add(file.getName());
        }
      }
    }
    return fileName;
  }
}
