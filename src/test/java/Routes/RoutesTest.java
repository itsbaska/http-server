package Routes;

import Router.Handler.GETHandler;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static utils.Method.GET;

public class RoutesTest {

  @Test
  public void add() {
    Routes routes = new Routes();
    routes.add(GET, "/", new GETHandler());
    assertNotNull(routes.routes.get("/"));
  }
}