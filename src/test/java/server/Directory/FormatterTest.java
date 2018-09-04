package server.Directory;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FormatterTest {

  @Test
  public void link() {
    assertEquals("<a href=\"/link.txt\">link.txt</a>", Formatter.link("link.txt"));
  }

  @Test
  public void list() {
    ArrayList<String> list = new ArrayList<>();
    list.add("file1.txt");
    list.add("file2.txt");

    String html =
      "<ul>\n" +
        "<li><a href=\"/file1.txt\">file1.txt</a></li>\n" +
        "<li><a href=\"/file2.txt\">file2.txt</a></li>\n" +
        "</ul>\n";


    assertEquals(html, Formatter.unorderedList(list));
  }
}