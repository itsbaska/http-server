package server.Directory;

import http_server_app.application.config.Config;
import http_server_app.server.Directory.FileHandler;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

//  @Test
//  public void getFileNames() {
//    Directory directory = new Directory();
//    ArrayList<String> files = new ArrayList<>();
//    files.add("file1");
//    files.add("file2");
//    files.add("image.gif");
//    files.add("image.jpeg");
//    files.add("image.png");
//    files.add("partial_content.txt");
//    files.add("patch-content.txt");
//    files.add("text-file.txt");
//
//    Collection<String> listOne = files;
////    Collection<String> listTwo = directory.getFileNames(Config.publicDirectory);
//
//    List<String> expectedList = new ArrayList<>(listOne);
//    List<String> actualList = new ArrayList<>(listTwo);
//
//    expectedList.removeAll( listTwo );
//    actualList.removeAll( listOne );
//
//    assertEquals(expectedList, actualList);
//  }

  @Test
  public void getFileExtention() {
    FileHandler fileHandler = new FileHandler(new File(Config.publicDirectory.getPath() + "/image.gif"));
    assertEquals("gif", fileHandler.getFileExtension());
  }

  @Test
  public void getFileExtentionWhenNoExtension() {
    FileHandler fileHandler = new FileHandler(new File(Config.publicDirectory.getPath() + "file1"));
    assertEquals("", fileHandler.getFileExtension());
  }
}
