package Controller.Handler;

import Request.Request;
import org.junit.Test;

import static Config.Method.GET;
import static org.junit.Assert.*;

public class GETEchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETEchoHandlerPath() {
    Handler handler = new GETEchoHandler();
    assertEquals("/echo", ((GETEchoHandler) handler).path);
  }

  @Test
  public void testGETEchoHandlerMethod() {
    Handler handler = new GETEchoHandler();
    assertEquals(GET, ((GETEchoHandler) handler).method);
  }

  @Test
  public void handlerReturnResponseBody() {
    Handler handler = new GETEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request.Builder().build(requestString);
    assertEquals("", handler.handle(request).body);
  }

  @Test
  public void handlerReturnResponseStatusCode() {
    Handler handler = new GETEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request.Builder().build(requestString);
    assertEquals(200, handler.handle(request).statusCode);
  }

  @Test
  public void handlerReturnResponseContentLength() {
    Handler handler = new GETEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request.Builder().build(requestString);
    assertEquals(0, handler.handle(request).contentLength);
  }
}