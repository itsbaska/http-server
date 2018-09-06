package server.Routes;

import application.controller.Handler.Handler;

import java.util.HashMap;

public class Routes {
  public HashMap<String, Route> routes = new HashMap<String, Route>();

  public void add(String path, Handler handler) {
    Route newRoute = new Route(path, handler);
    routes.put(path, newRoute);
  }
}
