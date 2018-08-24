package Router.Handler;
import Request.Request;
import Response.Response;

public class OPTIONS2Handler extends Handler{
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setHeader("Allow", "OPTIONS, GET")
      .build();
  }
}
