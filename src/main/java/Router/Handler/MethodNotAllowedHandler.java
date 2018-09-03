package Router.Handler;

import Response.Response;

public class MethodNotAllowedHandler extends Handler {
  public Response getResponse() {
    return new Response.Builder()
      .setStatusCode(405)
      .build();
  }
}
