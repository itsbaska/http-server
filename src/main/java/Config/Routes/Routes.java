package Config.Routes;

import Config.Method;
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

  public Route getNotFound() {
    Route notFound = null;
    for (Route route : getRoutes()) {
      if (route.method.equals(Method.GET) && route.path.equals("/not-found")) notFound = route;
    }
    return notFound;
  }

  public Route find(Request request) {
    Route requestedRoute = getNotFound();
    for (Route route : getRoutes()) {
      if (route.method.equals(request.method) && route.path.equals(request.path)) {
        requestedRoute = route;
        break;
      }
    }
    return requestedRoute;
  }
}
