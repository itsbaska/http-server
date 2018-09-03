package Router;

import Config.Config;
import Request.Request;
import Response.Response;
import Router.Handler.Handler;
import Router.Handler.MethodNotAllowedHandler;
import Router.Handler.NotFoundHandler;
import Routes.Route;
import Routes.Routes;
import utils.Method;


public class Router {
  public Routes routes;

  public Router() {
    this.routes = Config.routes;
  }

  public Response handleRequest(Request request) {
    request.log();
    Route route = routes.routes.get(request.path);
    Handler handler = getHandler(route, request.method);
    return getResponse(handler, request);
  }

  private Handler getHandler(Route route, Method method) {
    if (route == null) {
      return new NotFoundHandler();
    } else {
      return route.handlers.get(method);
    }
  }

  private Response getResponse(Handler handler, Request request) {
    if (handler == null) {
      System.out.println("is null");
      return new MethodNotAllowedHandler().getResponse();
    } else {
      return handler.getResponse(request);
    }
  }
}
