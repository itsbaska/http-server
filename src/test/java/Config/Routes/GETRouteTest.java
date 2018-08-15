package Config.Routes;

import Controller.Handler.GETHandler;
import Request.Request;
import org.junit.Test;

import static Config.Method.GET;
import static org.junit.Assert.*;

public class GETRouteTest {
  private String CRLF = "\r\n";

  @Test
    public void testGETMethod() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    assertEquals(route.method, GET);
  }

  @Test
  public void testGETPath() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    assertEquals(route.path, "/");
  }

  @Test
  public void testGETHandlerPath() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    assertEquals(((GETHandler) route.handler).path, "/");
  }

  @Test
  public void testGETHandlerMethod() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    assertEquals(((GETHandler) route.handler).method, GET);
  }

  @Test
  public void testGETHandlerResponseStatusCode() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).statusCode, 200);
  }

  @Test
  public void testGETHandlerResponseContentLength() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).contentLength, 0);
  }

  @Test
  public void testGETHandlerResponseBody() {
    GETRoute route = new GETRoute(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).body, "");
  }
}