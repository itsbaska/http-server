package http_server_app.application.controllers;

import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.NOT_ALLOWED;

public class MethodNotAllowedHandler extends Handler {
  public Response getResponse() {
    return new Response.Builder()
      .setStatusCode(NOT_ALLOWED)
      .build();
  }
}
