package application.controller.Handler;
import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.FOUND;

public class RedirectHandler extends Handler {
  public Response get(Request request) {
    return new Response.Builder()
      .setStatusCode(FOUND)
      .setHeader("Location", "/")
      .build();
  }
}
