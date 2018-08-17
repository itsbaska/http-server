package Controller.Handler;
import Request.Request;
import Response.Response;
import Config.Method;

public class GETHandler extends Handler {
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setHeader("Content-Length", "0")
      .setHeader("Content-Type", "text/html")
      .build();
  }
}
