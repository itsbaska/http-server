package server.Routes;

import http_server_app.application.controller.Handler.RootHandler;
import http_server_app.server.Routes.Routes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoutesTest {

  @Test
  public void add() {
    Routes routes = new Routes();
    routes.add("/", new RootHandler());
    assertEquals(routes.routes.size(), 1 );
  }
}