package Router.Handler;

import Config.Config;
import Directory.Directory;
import Request.Request;
import Response.Response;

public class GETHandler extends Handler {
  public Response getResponse(Request request) {
    Directory directory = new Directory(Config.publicDirectory);
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(directory.get().getBytes())
      .build();
  }
}