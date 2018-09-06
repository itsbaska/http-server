package application.controller.Handler;

import server.Directory.Layouts;
import application.config.Config;
import server.Directory.FileHandler;
import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.OK;
import static server.utils.StatusCode.UNAUTHORIZED;


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
