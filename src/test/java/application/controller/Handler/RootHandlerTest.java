package application.controller.Handler;

import server.Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static server.utils.StatusCode.OK;

public class RootHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETRootStatusToBe200() {
  Handler handler = new RootHandler();
  String requestString = "GET / HTTP/1.1" + CRLF +
    "Content-Type: text/plain" + CRLF;
    Request request = new Request(requestString).build();
    assertEquals(OK, handler.get(request).status);
  }

  @Test
  public void testGETRootBodyToHaveDirecoryContents() {
    Handler handler = new RootHandler();
    String requestString = "GET / HTTP/1.1" + CRLF;
    Request request = new Request(requestString).build();
    String rootContent = "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <title>Title</title>\n" +
      "</head>\n" +
      "<body>\n" +
      "<ul>\n" +
      "<li><a href=\"/text-file.txt\">text-file.txt</a></li>\n" +
      "<li><a href=\"/file2\">file2</a></li>\n" +
      "<li><a href=\"/patch-content.txt\">patch-content.txt</a></li>\n" +
      "<li><a href=\"/image.gif\">image.gif</a></li>\n" +
      "<li><a href=\"/image.jpeg\">image.jpeg</a></li>\n" +
      "<li><a href=\"/file1\">file1</a></li>\n" +
      "<li><a href=\"/partial_content.txt\">partial_content.txt</a></li>\n" +
      "<li><a href=\"/image.png\">image.png</a></li>\n" +
      "</ul>\n" +
      "</body>\n" +
      "</html>";
    assertEquals(rootContent, new String(handler.get(request).body));
  }
}