package Routes;

import Router.Handler.Handler;
import utils.Method;

import java.util.HashMap;

public class Routes {
  public HashMap<String, Route> routes = new HashMap<String, Route>();

  public void add(Method method, String path, Handler handler) {
    if (routes.get(path) == null) {
      Route newRoute = new Route(path);
      newRoute.setHandler(method, handler);
      routes.put(path, newRoute);
    } else {
      Route route = routes.get(path);
      if (isNewMethod(route, method)) {
        route.setHandler(method, handler);
      }
    }
  }

  private boolean isNewMethod(Route route, Method method) {
    return !route.handlers.containsKey(method);
  }
}
