package Router.Handler;
import Request.Request;
import Response.Response;

public class RedirectHandler extends Handler {
  public Response getResponse(Request request) {

    return new Response.Builder()
      .setStatusCode(302)
      .setHeader("Location", "/")
      .build();
  }
}
