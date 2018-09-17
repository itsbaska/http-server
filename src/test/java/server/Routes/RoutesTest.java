package server.Routes;

import http_server_app.application.controllers.EchoHandler;
import http_server_app.server.Routes.Routes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoutesTest {

  @Test
  public void add() {
    Routes routes = new Routes();
    routes.add("/echo", new EchoHandler());
    assertEquals(1, routes.routes.size());
  }
}