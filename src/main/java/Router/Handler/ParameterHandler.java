package Router.Handler;

import Request.Request;
import Response.Response;
import Request.Parameters;

public class ParameterHandler extends Handler {
  public Response getResponse(Request request) {
    String body = Parameters.format(request.parameters).toString();
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(body.getBytes())
      .build();
  }
}
