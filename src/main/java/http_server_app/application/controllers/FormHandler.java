package http_server_app.application.controllers;

import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.ACCEPTED;
import static http_server_app.server.utils.StatusCode.CREATED;

public class FormHandler extends Handler {
  public Response post(Request request) {
    return new Response.Builder()
      .setStatusCode(CREATED)
      .build();
  }

  public Response put(Request request) {
    return new Response.Builder()
      .setStatusCode(ACCEPTED)
      .build();
  }
}
