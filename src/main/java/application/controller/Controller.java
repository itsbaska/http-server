package application.controller;

import application.controller.Handler.NotFoundHandler;
import application.config.Config;
import server.Request.Request;
import server.Response.Response;
import server.Routes.Route;
import server.Routes.Routes;
import server.utils.StatusCode;


public class Controller {
  public Routes routes;

  public Controller() {
    this.routes = Config.routes;
  }

  public Response handleRequest(Request request) {
    request.log();
    Route route = routes.routes.get(request.path);

    if (route == null) {
      return new NotFoundHandler().get();
    } else {
      switch (request.method) {
        case GET:
          return route.handler.get(request);
        case POST:
          return route.handler.post(request);
        case PUT:
          return route.handler.put(request);
        case PATCH:
          return route.handler.patch(request);
        case DELETE:
          return route.handler.delete(request);
        case HEAD:
          return route.handler.head(request);
        case OPTIONS:
          return route.handler.options(request);
        default:
          return new Response.Builder()
            .setStatusCode(StatusCode.NOT_ALLOWED)
            .build();
      }
    }
  }
}
