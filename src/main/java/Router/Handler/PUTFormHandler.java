package Router.Handler;

import Request.Request;
import Response.Response;

public class PUTFormHandler extends Handler {
  public Response getResponse(Request request) {
    return new Response.Builder()
      .setStatusCode(202)
      .build();
  }
}
