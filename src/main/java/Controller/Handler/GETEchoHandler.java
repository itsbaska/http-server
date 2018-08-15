package Controller.Handler;

import Request.Request;
import Response.Response;
import Config.Method;

public class GETEchoHandler extends Handler {
  public GETEchoHandler() {
    this.method = Method.GET;
    this.path = "/echo";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setbody("")
      .setStatusCode(200)
      .build();
  }
}
