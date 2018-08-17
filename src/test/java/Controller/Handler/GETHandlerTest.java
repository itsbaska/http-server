package Controller.Handler;

import Request.Request;
import org.junit.Test;
import static Config.Method.GET;

import static org.junit.Assert.*;

public class GETHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETHandlerPath() {
    Handler handler = new GETHandler();
    assertEquals("/", ((GETHandler) handler).path);
  }

  @Test
  public void testGETHandlerMethod() {
    Handler handler = new GETHandler();
    assertEquals(GET, ((GETHandler) handler).method);
  }

  @Test
  public void handlerReturnResponseBody() {
    Handler handler = new GETHandler();
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals("", handler.handle(request).body);
  }

  @Test
  public void handlerReturnResponseStatusCode() {
  Handler handler = new GETHandler();
  String requestString = "GET / HTTP/1.1" + CRLF +
    "Content-Type: text/plain" + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(200, handler.handle(request).statusCode);
  }

  @Test
  public void handle() {
    Handler handler = new GETHandler();
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(0, handler.handle(request).contentLength);
  }
}