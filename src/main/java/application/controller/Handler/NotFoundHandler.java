package application.controller.Handler;

import server.Response.Response;

import static server.utils.StatusCode.NOT_FOUND;

public class NotFoundHandler extends Handler {
  public Response get() {
    return new Response.Builder()
      .setStatusCode(NOT_FOUND)
      .build();
  }
}
