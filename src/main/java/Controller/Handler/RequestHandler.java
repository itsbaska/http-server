package Controller.Handler;

import Request.Request;
import Response.Response;

public class RequestHandler {
  private Handler handler;

  public RequestHandler(Handler handler) {
    this.handler = handler;
  }

  public Response handleRequest(Request request, Response response) {
    return handler.handle(request, response);
  }
}
