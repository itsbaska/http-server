package Config;

import Request.Request;

import java.util.ArrayList;

public class Routes {
  private static ArrayList<Route> routes;
  public static void create() {
    System.out.println("I got into crete");
    routes = new ArrayList<>();
    routes.add(new Route.Builder()
      .setMethod("GET")
      .setPath("/")
      .build());
    routes.add(new Route.Builder()
      .setMethod("POST")
      .setPath("/echo")
      .build());
    routes.add(new Route.Builder()
      .setMethod("GET")
      .setPath("/echo")
      .build());
    routes.add(new Route.Builder()
      .setMethod("POST")
      .setPath("/form")
      .build());
  }

  public static ArrayList all() {
    return routes;
  }

  public static Route find(Request request) {
    Route foundRoute = null;

    for (int i = 0; i < routes.size(); i++) {
      if (routes.get(i).method.equals(request.method) &&
          routes.get(i).path.equals(request.path)) {
        foundRoute = routes.get(i);
      }
    }
    return foundRoute;
  }
}
