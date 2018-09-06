package application.controller.Handler;

import server.Request.Request;
import server.Response.Response;
import static server.utils.StatusCode.OK;


public class EchoHandler extends Handler {
  public Response get(Request request) {
    return new Response.Builder()
      .setStatusCode(OK)
      .build();
  }

  public Response post(Request request) {
    return new Response.Builder()
      .setBody(request.body.getBytes())
      .setHeader("Content-Length", String.valueOf(request.body.length()))
      .setHeader("Content-Type", "text/html")
      .setStatusCode(OK)
      .build();
  }
}
