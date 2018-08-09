package Controller.Matcher;

import Config.Config;
import Config.Routes.Route;
import Request.Request;

import java.util.ArrayList;

public class Matcher {
  public static Route getRoute(Request request) {
    ArrayList<Route> routes = Config.allRoutes();
    Route route = null;
    for(int i = 0; i < routes.size(); i++) {
      if(routes.get(i).getMethod().equals(request.method) && routes.get(i).getPath().equals(request.path)) {
         route = routes.get(i);
      }
    }
    return route;
  }
}
