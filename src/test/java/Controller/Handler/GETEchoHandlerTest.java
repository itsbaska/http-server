package Controller.Handler;

import Controller.Controller;
import Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GETEchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void handlerReturnResponseBody() {
    Handler handler = new GETEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Controller controller = new Controller();
    Request request = new Request.Builder().build(requestString);
    assertEquals("", controller.handleRequest(request).body);
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