package http_server_app.application.controllers;

import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.ServerConfig;
import http_server_app.storage.Data;

import static http_server_app.server.utils.StatusCode.OK;

public class FormDataHandler extends Handler {

  public Response get(Request request) {
    String body = "";
    if (ServerConfig.storage.find(1) != null) {
      body = ServerConfig.storage.find(1).body;
    }
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(body.getBytes())
      .build();
  }

  public Response post(Request request) {
    ServerConfig.storage.add(new Data(request.body));
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(ServerConfig.storage.find(1).body.getBytes())
      .build();
  }

  public Response put(Request request) {
    ServerConfig.storage.update(1, new Data(request.body));
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(ServerConfig.storage.find(1).body.getBytes())
      .build();
  }

  public Response delete(Request request) {
    ServerConfig.storage.delete(1);
    return new Response.Builder()
      .setStatusCode(OK)
      .build();
  }
}
