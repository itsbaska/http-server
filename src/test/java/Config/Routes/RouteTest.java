package Config.Routes;

import Controller.Handler.GETHandler;
import Controller.Handler.POSTEchoHandler;
import Request.Request;
import org.junit.Test;

import static Config.Method.GET;
import static Config.Method.POST;
import static org.junit.Assert.*;

public class RouteTest {
  private String CRLF = "\r\n";

  @Test
  public void testGETMethod() {
    Route route = new Route(GET, "/", new GETHandler());
    assertEquals(route.method, GET);
  }

  @Test
  public void testGETPath() {
    Route route = new Route(GET, "/", new GETHandler());
    assertEquals(route.path, "/");
  }

  @Test
  public void testGETHandlerResponseStatusCode() {
    Route route = new Route(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).statusCode, 200);
  }

  @Test
  public void testGETHandlerResponseContentLength() {
    Route route = new Route(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).contentLength, 0);
  }

  @Test
  public void testGETHandlerResponseBody() {
    Route route = new Route(GET, "/", new GETHandler());
    String requestString = "GET / HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(requestString);
    assertEquals(route.handler.handle(request).body, "");
  }
  @Test
  public void testPOSTMethod() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    assertEquals(POST, route.method);
  }

  @Test
  public void testPOSTPath() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    assertEquals("/echo", route.path);
  }

  @Test
  public void testPOSTEchoHandlerResponseStatusCode() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals(200, route.handler.handle(request).statusCode);
  }

  @Test
  public void testPOSTEchoHandlerResponseContentLength() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals(7, route.handler.handle(request).contentLength);
  }

  @Test
  public void testPOSTEchoHandlerResponseBody() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    String requestString = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(requestString);
    assertEquals("goodbye", route.handler.handle(request).body);
  }

}