package Directory;

import java.io.File;
import java.util.ArrayList;

public class FileHandler {
  private final String root;
  private String filePath;

  public FileHandler(String rootPath, String filePath) {
    this.root = rootPath;
    this.filePath = filePath;
  }

  public ArrayList<String> getFileNames() {
    ArrayList<String> fileName = new ArrayList<>();
    File folder = new File("." + root + "/public" + filePath);
    File[] listOfFiles = folder.listFiles();

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
