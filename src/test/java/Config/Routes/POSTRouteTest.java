package Config.Routes;

import Controller.Handler.POSTEchoHandler;
import Request.Request;
import org.junit.Test;

import static Config.Method.POST;
import static org.junit.Assert.*;

public class POSTRouteTest {
  private String CRLF = "\r\n";

  @Test
  public void testPOSTMethod() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    assertEquals(POST, route.method);
  }

  @Test
  public void testPOSTPath() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    assertEquals("/echo", route.path);
  }

  @Test
  public void testPOSTEchoHandlerPath() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    assertEquals("/echo", ((POSTEchoHandler) route.handler).path);
  }

  @Test
  public void testPOSTEchoHandlerMethod() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    assertEquals(POST, ((POSTEchoHandler) route.handler).method);
  }

  @Test
  public void testPOSTEchoHandlerResponseStatusCode() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals(200, route.handler.handle(request).statusCode);
  }

  @Test
  public void testPOSTEchoHandlerResponseContentLength() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals(7, route.handler.handle(request).contentLength);
  }

  @Test
  public void testPOSTEchoHandlerResponseBody() {
    POSTRoute route = new POSTRoute(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals("goodbye", route.handler.handle(request).body);
  }

}