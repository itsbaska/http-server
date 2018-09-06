package application.controller.Handler;

import application.config.Config;
import server.Request.Request;
import server.Response.Response;
import storage.Data;

import static server.utils.StatusCode.OK;

public class FormDataHandler extends Handler {

  public Response get(Request request) {
    String body = "";
    if (Config.storage.find(1) != null) {
      body = Config.storage.find(1).body;
    }
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(body.getBytes())
      .build();
  }

  public Response post(Request request) {
    Config.storage.add(new Data(request.body));
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(Config.storage.find(1).body.getBytes())
      .build();
  }

  public Response put(Request request) {
    Config.storage.update(1, new Data(request.body));
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(Config.storage.find(1).body.getBytes())
      .build();
  }

  public Response delete(Request request) {
    Config.storage.delete(1);
    return new Response.Builder()
      .setStatusCode(OK)
      .build();
  }
}
