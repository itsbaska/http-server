package Router.Handler;

import Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class POSTEchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void handlerReturnResponseBody() {
    Handler handler = new POSTEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request(requestString).build();
    assertEquals("hello", handler.handle(request).body);
  }

  @Test
  public void handlerReturnResponseStatusCode() {
    Handler handler = new POSTEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request(requestString).build();
    assertEquals(200, handler.handle(request).statusCode);
  }
}