package Router.Handler;

import Config.Config;
import Request.Request;
import Response.Response;

public class GETFormDataHandler extends Handler {
  public Response getResponse(Request request) {
    String body = "";
    if(Config.storage.find(1) != null) {
      body = Config.storage.find(1).body;
    }
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(body.getBytes())
      .build();
  }
}
