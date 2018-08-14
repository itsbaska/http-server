package Controller.Handler;

import Request.Request;
import org.junit.Test;

import static Config.Method.GET;
import static Config.Method.POST;
import static org.junit.Assert.assertEquals;

public class POSTEchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testPOSTEchoHandlerPath() {
    Handler handler = new POSTEchoHandler();
    assertEquals("/echo", ((POSTEchoHandler) handler).path);
  }

  @Test
  public void testPOSTEchoHandlerMethod() {
    Handler handler = new POSTEchoHandler();
    assertEquals(POST, ((POSTEchoHandler) handler).method);
  }

  @Test
  public void handlerReturnResponseBody() {
    Handler handler = new POSTEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request.Builder().build(requestString);
    assertEquals("hello", handler.handle(request).body);
  }

  @Test
  public void handlerReturnResponseStatusCode() {
    Handler handler = new POSTEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request.Builder().build(requestString);
    assertEquals(200, handler.handle(request).statusCode);
  }

  @Test
  public void handlerReturnResponseContentLength() {
    Handler handler = new POSTEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request.Builder().build(requestString);
    assertEquals(5, handler.handle(request).contentLength);
  }
}