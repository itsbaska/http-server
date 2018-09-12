package http_server_app.server.Routes;

import http_server_app.application.controller.Handler.Handler;

import java.util.HashMap;

public class Routes {
  public HashMap<String, Route> routes = new HashMap<>();

  public void add(String path, Handler handler) {
    Route newRoute = new Route(path, handler);
    routes.put(path, newRoute);
  }
}
