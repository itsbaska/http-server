package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public class PostEchoHandle extends Handler{
  public PostEchoHandle() {
    this.method = Method.POST;
    this.path = "/echo";
  }

  @Override
  public Response handle(Request request) {
    return new Response.Builder()
      .setbody(request.body)
      .setStatusCode(200)
      .build();
  }
}
