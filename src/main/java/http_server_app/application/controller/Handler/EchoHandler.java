package http_server_app.application.controller.Handler;

import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import static http_server_app.server.utils.StatusCode.OK;


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
