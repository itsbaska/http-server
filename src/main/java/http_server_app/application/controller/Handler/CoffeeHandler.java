package http_server_app.application.controller.Handler;

import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.TEAPOT;


public class CoffeeHandler extends Handler {
  public Response get(Request request) {
    return new Response.Builder()
      .setStatusCode(TEAPOT)
      .setBody("I'm a teapot".getBytes())
      .build();
  }
}
