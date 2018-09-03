package Router.Handler;
import Request.Request;
import Response.Response;

public abstract class Handler implements Handle {
  protected String fileName;
  Response response;

  public Response handle(Request request) {
    return response;
  }
}
