package Router.Handler;

import Request.Request;
import Response.Response;

public class HEAD200Handler extends Handler {
  public Response getResponse(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .build();
  }
}
