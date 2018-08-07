package Config;

import Request.Request;

import java.util.ArrayList;

public class Routes {
  private static ArrayList<Route> routes;
  public static void create() {
    routes = new ArrayList<>();
    routes.add(new Route("GET", "/"));
    routes.add(new Route("GET", "/echo"));
    routes.add(new Route("POST", "/echo"));
    routes.add(new Route("GET", "/form"));
    routes.add(new Route("POST", "/form"));
    routes.add(new Route("PUT", "/form"));
  }

  public static ArrayList all() {
    return routes;
  }

  public static Route find(Request request) {
    Route foundRoute = null;

    for (int i = 0; i < routes.size(); i++) {
      if (routes.get(i).method().equals(request.method) && routes.get(i).path().equals(request.path)) {
        foundRoute = routes.get(i);
      }
    }
    return foundRoute;
  }

  public static ArrayList get() {
    ArrayList<Route> getRoutes;
    getRoutes = new ArrayList<>();
    int i = 0;
    while (i < routes.size()) {
      if(routes.get(i).method.equals("GET"))
        getRoutes.add(routes.get(i));
      i++;
    }
    return getRoutes;
  }

  public ArrayList post() {
    ArrayList<Route> postRoutes;
    postRoutes = new ArrayList<>();
    int i = 0;
    while (i < routes.size()) {
      if(routes.get(i).method.equals("POST"))
        postRoutes.add(routes.get(i));
      i++;
    }
    return postRoutes;
  }
}
