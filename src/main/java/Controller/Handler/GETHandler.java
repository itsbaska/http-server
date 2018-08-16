package Controller.Handler;
import Request.Request;
import Response.Response;
import Config.Method;

public class GETHandler extends Handler {
  public Method method;
  public String path;

  public GETHandler() {
    this.method = Method.GET;
    this.path = "/";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setBody("")
      .setHeader("Content-Length", "0")
      .setHeader("Content-Type", "text/html")
      .build();
  }
}
