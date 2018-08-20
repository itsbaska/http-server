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
      .setStatusCode(200)
      .setBody("")
      .setHeader("Content-Length", "0")
      .setHeader("Content-Type", "text/html")
      .build();
  }
}
