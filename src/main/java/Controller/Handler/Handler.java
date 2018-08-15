package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public abstract class Handler implements Handle {
  public Method method;
  public String path;
  Response response;

  public Response handle(Request request) {
    return response;
  }
}
