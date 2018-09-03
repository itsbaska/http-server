package Router.Handler;

import Config.Config;
import Request.Request;
import Response.Response;

public class DELETEFormDataHandler extends Handler {
  public Response handle(Request request) {
    Config.storage.delete(1);
    return new Response.Builder()
      .setStatusCode(200)
      .build();
  }
}
