package application.controller.Handler;
import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.OK;

public class OPTIONSHandler extends Handler{
  public Response options(Request request) {
    return new Response.Builder()
      .setStatusCode(OK)
      .setHeader("Allow", "OPTIONS, GET, HEAD, POST, PUT")
      .build();
  }
}
