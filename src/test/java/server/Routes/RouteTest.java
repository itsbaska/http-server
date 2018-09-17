package server.Routes;

import http_server_app.application.config.Config;
import http_server_app.application.controllers.EchoHandler;
import http_server_app.application.controllers.DirectoryHandler;
import http_server_app.server.Routes.Route;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteTest {

  @Test
  public void testRouteHasPath() {
    Route route = new Route("/", new DirectoryHandler(Config.publicDirectory));
    assertEquals(route.path, "/");
  }

  @Test
  public void testRouteHasHandler() {
    Route route = new Route("/echo", new EchoHandler());
    assertEquals(EchoHandler.class, route.handler.getClass());
  }
}