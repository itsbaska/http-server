package Directory;

import Config.Config;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

  @Test
  public void getFileNames() {
    Directory directory = new Directory(Config.publicDirectory);
    ArrayList<String> files = new ArrayList<>();
    files.add("file1");
    files.add("file2");
    files.add("image.gif");
    files.add("image.jpeg");
    files.add("image.png");
    files.add("text-file.txt");

    Collection<String> listOne = files;
    Collection<String> listTwo = directory.getFileNames();

    List<String> expectedList = new ArrayList<>(listOne);
    List<String> actualList = new ArrayList<>(listTwo);

    expectedList.removeAll( listTwo );
    actualList.removeAll( listOne );

    assertEquals(expectedList, actualList);
  }
}
