package http_server_app.application.controller.Handler;

import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.NOT_FOUND;

public class NotFoundHandler extends Handler {
  public Response get() {
    return new Response.Builder()
      .setStatusCode(NOT_FOUND)
      .build();
  }
}
