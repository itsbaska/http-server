package Router.Handler;

import Router.Router;
import Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GETEchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void handlerReturnResponseBody() {
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Router router = new Router();
    Request request = new Request(requestString).build();
    assertNull(router.handleRequest(request).body);
  }

  @Test
  public void handlerReturnResponseStatusCode() {
    Handler handler = new GETEchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request(requestString).build();
    assertEquals(200, handler.getResponse(request).statusCode);
  }

}