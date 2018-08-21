package Controller.Handler;

import Config.Method;
import Request.Request;
import Response.Response;

public class POSTFormHandler extends Handler {
  public Response handle(Request request) {
    return new Response.Builder()
      .setStatusCode(201)
      .build();
  }
}
