package Controller;
import Config.Config;
import Config.Routes.Route;
import Config.Routes.Routes;
import Request.Request;
import Response.Response;


public class Controller {
  public Routes routes;

  public Controller() {
    this.routes = Config.setRoutes();
  }

  public Response handleRequest(Request request) {
    Route route = routes.find(request);
    return route.handler.handle(request);
  }
}
