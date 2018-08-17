package Controller.Handler;
import Request.Request;
import Response.Response;

public abstract class Handler implements Handle {
  Response response;

  public Response handle(Request request) {
    return response;
  }
}
