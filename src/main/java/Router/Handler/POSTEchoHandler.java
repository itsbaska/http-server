package Router.Handler;
import Request.Request;
import Response.Response;

public class POSTEchoHandler extends Handler{
  public Response handle(Request request) {
    return new Response.Builder()
      .setBody(request.body)
      .setHeader("Content-Length", String.valueOf(request.body.length()))
      .setHeader("Content-Type", "text/html")
      .setStatusCode(200)
      .build();
  }
}
