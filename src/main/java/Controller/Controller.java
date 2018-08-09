package Controller;
import Config.Config;
import Config.Routes.Route;
import Request.Request;
import Response.Response;

import java.util.ArrayList;

public class Controller {

  public Response handleRequest(Request request) {
    Route route = getRoute(request);
    return route.handler.handle(request);
  }

  private static Route getRoute(Request request) {
    ArrayList<Route> routes = Config.allRoutes();
    Route requestedRoute = null;
    for (Route route : routes) {
      if (route.getMethod().equals(request.method) && route.getPath().equals(request.path)) {
        requestedRoute = route;
      }
    }
    return requestedRoute;
  }
}
