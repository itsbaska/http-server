package application.controller.Handler;

import server.Response.Response;

import static server.utils.StatusCode.NOT_ALLOWED;

public class MethodNotAllowedHandler extends Handler {
  public Response getResponse() {
    return new Response.Builder()
      .setStatusCode(NOT_ALLOWED)
      .build();
  }
}
