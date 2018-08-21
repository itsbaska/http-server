package Controller.Handler;

import Request.Request;
import Response.Response;

public class GETEchoHandler extends Handler {
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(200)
      .setBody("")
      .build();
  }
}
