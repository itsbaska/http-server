package Controller.Handler;
import Request.Request;

import static Config.Routes.Method.GET;
import static Config.Routes.Method.POST;

public class HandlerFactory {
  public RequestHandler createHandler(Request request) {
    RequestHandler handler = null;
    if (request.method == GET) {
      handler = new RequestHandler(new GetHandler());
    } else if (request.method == POST) {
      handler = new RequestHandler(new PostHandler());
    }
    return handler;
  }
}
