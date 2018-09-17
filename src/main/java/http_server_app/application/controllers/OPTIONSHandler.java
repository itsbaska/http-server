package http_server_app.application.controllers;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.OK;

public class OPTIONSHandler extends Handler{
  public Response options(Request request) {
    return new Response.Builder()
      .setStatusCode(OK)
      .setHeader("Allow", "OPTIONS, GET, HEAD, POST, PUT")
      .build();
  }
}
