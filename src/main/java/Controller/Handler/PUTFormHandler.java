package Controller.Handler;

import Config.Method;
import Request.Request;
import Response.Response;

public class PUTFormHandler extends Handler {
  public PUTFormHandler() {
    this.method = Method.PUT;
    this.path = "/form";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setBody("")
      .setStatusCode(202)
      .build();
  }
}
