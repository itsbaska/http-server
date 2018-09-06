package application.controller.Handler;

import server.Request.Request;
import server.Response.Response;
import server.Request.Parameters;

import static server.utils.StatusCode.OK;

public class ParameterHandler extends Handler {
  public Response get(Request request) {
    String body = Parameters.format(request.parameters).toString();
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(body.getBytes())
      .build();
  }
}
