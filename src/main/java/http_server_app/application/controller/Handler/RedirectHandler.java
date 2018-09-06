package http_server_app.application.controller.Handler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.FOUND;

public class RedirectHandler extends Handler {
  public Response get(Request request) {
    return new Response.Builder()
      .setStatusCode(FOUND)
      .setHeader("Location", "/")
      .build();
  }
}
