package Router.Handler;

import Request.Request;
import Response.Response;

public class GETEchoHandler extends Handler {
  public Response getResponse(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .build();
  }
}
