package Controller.Handler;
import Request.Request;
import Response.Response;
import Config.Method;

public class GetHandle extends Handler {
  public Method method;
  public String path;

  public GetHandle() {
    this.method = Method.GET;
    this.path = "/";
  }

  @Override
  public Response handle(Request request) {
    return new Response.Builder()
      .setbody("")
      .setStatusCode(200)
      .build();
  }
}
