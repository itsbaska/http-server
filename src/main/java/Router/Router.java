package Router;
import Config.Config;
import Routes.Route;
import Routes.Routes;
import Request.Request;
import Response.Response;


public class Router {
  public Routes routes;

  public Router() {
    this.routes = Config.routes;
  }

  public Response handleRequest(Request request) {
    request.log();
    Route route = routes.find(request);
    return route.handler.handle(request);
  }
}
