package Controller.Handler;
import Request.Request;
import Response.Response;
import Config.Method;

public class GetEchoHandle extends Handler {
  public GetEchoHandle() {
    this.method = Method.GET;
    this.path = "/echo";
  }

  @Override
  public Response handle(Request request) {
    return new Response.Builder()
      .setbody("")
      .setStatusCode(200)
      .build();
  }
}
