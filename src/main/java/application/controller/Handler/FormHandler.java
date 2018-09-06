package application.controller.Handler;

import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.ACCEPTED;
import static server.utils.StatusCode.CREATED;

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
