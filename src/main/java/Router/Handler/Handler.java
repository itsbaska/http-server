package Router.Handler;
import Request.Request;
import Response.Response;

public abstract class Handler implements Handle {
  protected String fileName;
  Response response;

  public Response getResponse(Request request) {
    return response;
  }
}
