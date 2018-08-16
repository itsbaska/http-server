package Controller.Handler;
import Config.Method;
import Request.Request;
import Response.Response;

public class OPTIONSHandler extends Handler{
  public OPTIONSHandler() {
    this.method = Method.POST;
    this.path = "/method_options";
  }

  public Response handle(Request request) {
    Response response = new Response.Builder()
      .setbody(request.body)
      .setStatusCode(200)
      .setHeader("Allow", "OPTIONS, GET, HEAD, POST, PUT")
      .build();
    return response;
  }
}
