package Controller.Handler;

import Config.Method;
import Request.Request;
import Response.Response;

public class POSTFormHandler extends Handler {

  public POSTFormHandler() {
    this.method = Method.POST;
    this.path = "/form";
  }

  public Response handle(Request request) {
    return new Response.Builder()
      .setBody("")
      .setStatusCode(201)
      .build();
  }
}
