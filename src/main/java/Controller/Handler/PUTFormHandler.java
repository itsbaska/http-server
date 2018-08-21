package Controller.Handler;

import Config.Method;
import Request.Request;
import Response.Response;

public class PUTFormHandler extends Handler {
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(202)
      .build();
  }
}
