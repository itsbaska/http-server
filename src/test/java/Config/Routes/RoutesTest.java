package Config.Routes;

import Controller.Handler.GETEchoHandler;
import Controller.Handler.GETHandler;
import Controller.Handler.POSTEchoHandler;
import org.junit.Test;

import static Config.Method.GET;
import static Config.Method.POST;
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
}