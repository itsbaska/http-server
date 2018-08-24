package Routes;

import Router.Handler.GETHandler;
import Router.Handler.POSTEchoHandler;
import org.junit.Test;

import static utils.Method.GET;
import static utils.Method.POST;
import static org.junit.Assert.assertEquals;

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
  public void testPOSTMethod() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    assertEquals(POST, route.method);
  }

  @Test
  public void testPOSTPath() {
    Route route = new Route(POST, "/echo", new POSTEchoHandler());
    assertEquals("/echo", route.path);
  }
}