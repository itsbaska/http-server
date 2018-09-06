package http_server_app.application.controller.Handler;

import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.Request.Parameters;

import static http_server_app.server.utils.StatusCode.OK;

public class ParameterHandler extends Handler {
  public Response get(Request request) {
    String body = Parameters.format(request.parameters).toString();
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(body.getBytes())
      .build();
  }
}
