package server.Directory;

import http_server_app.server.Directory.Formatter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

  @Test
  public void htmlList() {
    ArrayList<String> list = new ArrayList<>();
    list.add("file1.txt");
    list.add("file2.txt");

    String html =
      "<ul>\n" +
        "<li>file1.txt</li>\n" +
        "<li>file2.txt</li>\n" +
        "</ul>\n";
    assertEquals(html, Formatter.htmlList(list));
  }
}