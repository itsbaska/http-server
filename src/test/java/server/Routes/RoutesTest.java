package server.Routes;

import http_server_app.application.config.Config;
import http_server_app.application.controller.Handler.DirectoryHandler;
import http_server_app.server.Routes.Routes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoutesTest {

  @Test
  public void add() {
    Routes routes = new Routes();
    routes.add("/", new DirectoryHandler(Config.publicDirectory));
    assertEquals(routes.routes.size(), 1 );
  }
}