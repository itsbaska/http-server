package Controller.Handler;
import Request.Request;
import Response.Response;

public class RedirectHandler extends Handler {
  public Response handle(Request request) {

    return new Response.Builder()
      .setStatusCode(302)
      .setHeader("Location", "http://127.0.0.1:3000/")
      .build();
  }
}
