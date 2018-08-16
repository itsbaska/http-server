package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public class OPTIONS2Handler extends Handler{
  public OPTIONS2Handler() {
    this.method = Method.POST;
    this.path = "/method_options2";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setHeader("Allow", "OPTIONS, GET")
      .build();
  }
}
