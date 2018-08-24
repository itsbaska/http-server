package Routes;

import Router.Handler.GETEchoHandler;
import Router.Handler.GETHandler;
import Router.Handler.NotFoundHandler;
import Request.Request;
import org.junit.Test;

import static utils.Method.GET;
import static org.junit.Assert.*;

public class RoutesTest {

  @Test
  public void add() {
    Routes routes = new Routes();
    Route route = new Route(GET, "/", new GETHandler());
    routes.add(route);
    assertEquals(routes.getRoutes().get(0), route);
  }

  @Test
  public void getRoutes() {
    Routes routes = new Routes();
    Route route = new Route(GET, "/echo", new GETEchoHandler());
    routes.add(route);
    assertTrue(routes.getRoutes().contains(route));
  }

  @Test
  public void getNotFound() {
    String CRLF = "\r\n";
    String requestString = "GET /wrong-address HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request("GET", "/wrong-address", "goodbye", requestString);
    Routes routes = new Routes();
    Route route = new Route(GET, "/not-found", new NotFoundHandler());
    routes.add(route);
    assertEquals(routes.find(request), route);
  }

  @Test
  public void find() {
    String CRLF = "\r\n";
    String requestString = "GET /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request("GET", "/echo", "goodbye", requestString);
    Routes routes = new Routes();
    Route route = new Route(GET, "/echo", new GETEchoHandler());
    routes.add(route);
    assertEquals(routes.find(request), route);
  }
}