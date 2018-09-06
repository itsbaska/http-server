package application.controller.Handler;
import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.OK;

public class OPTIONS2Handler extends Handler{
  public Response options(Request request) {
    return new Response.Builder()
      .setStatusCode(OK)
      .setHeader("Allow", "OPTIONS, GET")
      .build();
  }
}
