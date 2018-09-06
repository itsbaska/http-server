package http_server_app.application.controller.Handler;

import http_server_app.server.Directory.Layouts;
import http_server_app.application.config.Config;
import http_server_app.server.Directory.FileHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.OK;
import static http_server_app.server.utils.StatusCode.UNAUTHORIZED;


public class AUTHHandler extends Handler {
  public Response get(Request request) {
    FileHandler log = new FileHandler(Config.logger.logFile);
    if (Config.credential.isAuthorized(request)) {
      return new Response.Builder()
        .setStatusCode(OK)
        .setBody(Layouts.html(log.toHtmlList()).getBytes())
        .build();
    } else {
      return new Response.Builder()
        .setStatusCode(UNAUTHORIZED)
        .setHeader("WWW-Authenticate", "Basic")
        .build();
    }
  }
}
