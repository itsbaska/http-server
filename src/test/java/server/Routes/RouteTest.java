package server.Routes;

import application.controller.Handler.EchoHandler;
import application.controller.Handler.RootHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteTest {

  @Test
  public void testRouteHasPath() {
    Route route = new Route("/", new RootHandler());
    assertEquals(route.path, "/");
  }

  @Test
  public void testRouteHasHandler() {
    Route route = new Route("/echo", new EchoHandler());
    assertEquals(EchoHandler.class, route.handler.getClass());
  }
}