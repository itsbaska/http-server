package Directory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

  @Test
  public void getFileNames() {
    FileHandler fileHandler = new FileHandler("/src/main/java/assets", "/");
    ArrayList<String> files = new ArrayList<>();
    files.add("file1");
    files.add("file2");
    files.add("image.gif");
    files.add("image.png");
    files.add("text-file.txt");

    Collection<String> listOne = files;
    Collection<String> listTwo = fileHandler.getFileNames();

    List<String> expectedList = new ArrayList<>(listOne);
    List<String> actualList = new ArrayList<>(listTwo);

    expectedList.removeAll( listTwo );
    actualList.removeAll( listOne );

    assertEquals(expectedList, actualList);
  }
}
