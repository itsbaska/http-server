package http_server_app.server.Routes;

import http_server_app.application.controllers.NotFoundHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.ServerConfig;
import http_server_app.server.utils.StatusCode;


public class Controller {
  private static Routes routes;

  public Controller(Routes routes) {
    this.routes = routes;
  }

  public static Response handleRequest(Request request) {
    ServerConfig.logger.log("REQUEST", request.getRequestLine());
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
