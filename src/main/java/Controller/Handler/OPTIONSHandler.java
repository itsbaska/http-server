package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public class OPTIONSHandler extends Handler{
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setHeader("Allow", "OPTIONS, GET, HEAD, POST, PUT")
      .build();
  }
}
