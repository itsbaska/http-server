package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public class POSTEchoHandler extends Handler{
  public POSTEchoHandler() {
    this.method = Method.POST;
    this.path = "/echo";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setbody(request.body)
      .setStatusCode(200)
      .build();
  }
}
