package Routes;

import Router.Handler.GETHandler;
import Router.Handler.POSTEchoHandler;
import org.junit.Test;

import static utils.Method.GET;
import static utils.Method.POST;
import static org.junit.Assert.assertEquals;

public class RouteTest {

  @Test
  public void testGETPath() {
    Route route = new Route("/");
    route.setHandler(GET, new GETHandler());
    assertEquals(route.path, "/");
  }

  @Test
  public void testPOSTPath() {
    Route route = new Route("/echo");
    route.setHandler(POST, new POSTEchoHandler());
    assertEquals("/echo", route.path);
  }
}