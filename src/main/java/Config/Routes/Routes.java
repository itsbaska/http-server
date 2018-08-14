package Config.Routes;

import Request.Request;

import java.util.ArrayList;

public class Routes {
  public ArrayList<Route> routes = new ArrayList<>();

  public void add(Route route) {
    routes.add(route);
  }

  public ArrayList<Route> getRoutes() {
    return routes;
  }

  public Route find(Request request) {
    Route requestedRoute = null;
    for (Route route : getRoutes()) {
      if (route.getMethod().equals(request.method) && route.getPath().equals(request.path)) {
        requestedRoute = route;
      }
    }
    return requestedRoute;
  }
}
