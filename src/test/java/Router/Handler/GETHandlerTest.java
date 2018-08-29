package Router.Handler;

import Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GETHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void handlerReturnResponseStatusCode() {
  Handler handler = new GETHandler();
  String requestString = "GET / HTTP/1.1" + CRLF +
    "Content-Type: text/plain" + CRLF;
    Request request = new Request(requestString).build();
    assertEquals(200, handler.handle(request).statusCode);
  }

  @Test
  public void handle() {
    Handler handler = new GETHandler();
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF;
    Request request = new Request(requestString).build();
    assertEquals(0, handler.handle(request).contentLength);
  }
}