package application.controller.Handler;

import http_server_app.application.config.Config;
import http_server_app.application.controller.Handler.Handler;
import http_server_app.application.controller.Handler.DirectoryHandler;
import http_server_app.server.Request.Request;
import org.junit.Test;

import static http_server_app.server.utils.StatusCode.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectoryHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETRootStatusToBe200() {
  Handler handler = new DirectoryHandler(Config.publicDirectory);
  String requestString = "GET / HTTP/1.1" + CRLF +
    "Content-Type: text/plain" + CRLF;
    Request request = new Request(requestString).build();
    assertEquals(OK, handler.get(request).status);
  }

  @Test
  public void testGETRootBodyToHaveDirectoryContents() {
    Handler handler = new DirectoryHandler(Config.publicDirectory);
    String requestString = "GET / HTTP/1.1" + CRLF;
    Request request = new Request(requestString).build();
    String expected = new String(handler.get(request).body);
    assertTrue(expected.contains("text-file.txt"));
    assertTrue(expected.contains("file1"));
    assertTrue(expected.contains("file2"));
    assertTrue(expected.contains("patch-content.txt"));
    assertTrue(expected.contains("image.gif"));
    assertTrue(expected.contains("image.jpeg"));
    assertTrue(expected.contains("image.png"));
    assertTrue(expected.contains("partial_content.txt"));
  }
}