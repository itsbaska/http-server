package application.controller.Handler;

import http_server_app.application.controller.Controller;
import http_server_app.application.controller.Handler.EchoHandler;
import http_server_app.application.controller.Handler.Handler;
import http_server_app.server.Request.Request;
import org.junit.Test;

import static http_server_app.server.utils.StatusCode.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EchoHandlerTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETEchoBodyToBeEmpty() {
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Controller controller = new Controller();
    Request request = new Request(requestString).build();
    assertNull(controller.handleRequest(request).body);
  }

  @Test
  public void testGetEchoStatusToBe200() {
    Handler handler = new EchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request(requestString).build();
    assertEquals(OK, handler.get(request).status);
  }

  @Test
  public void testPOSTEchoBodyToReturnRequestBody() {
    Handler handler = new EchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";
    Request request = new Request(requestString).build();
    assertEquals("hello", new String(handler.post(request).body));
  }

  @Test
  public void testPOSTEchoStatusToBe200() {
    Handler handler = new EchoHandler();
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 5" + CRLF + CRLF +
      "hello";

    Request request = new Request(requestString).build();
    assertEquals(OK, handler.post(request).status);
  }

}