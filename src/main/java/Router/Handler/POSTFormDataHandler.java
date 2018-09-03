package Router.Handler;

import Config.Config;
import Request.Request;
import Response.Response;
import Storage.Data;

public class POSTFormDataHandler extends Handler {
  public Response handle(Request request) {
    Config.storage.add(new Data(request.body));
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(Config.storage.find(1).body)
      .build();
  }
}
