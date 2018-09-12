package http_server_app.application.controller.Handler;

import http_server_app.server.Directory.Formatter;
import http_server_app.server.Directory.Layouts;
import http_server_app.application.config.Config;
import http_server_app.server.Directory.FileHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import java.util.ArrayList;
import java.util.Arrays;

import static http_server_app.server.utils.StatusCode.OK;
import static http_server_app.server.utils.StatusCode.UNAUTHORIZED;

public class AUTHHandler extends Handler {
  public Response get(Request request) {
    FileHandler log = new FileHandler(Config.logger.logFile);
    if (Config.credential.isAuthorized(request)) {
      return new Response.Builder()
        .setStatusCode(OK)
        .setBody(Layouts.html(toHtmlList()).getBytes())
        .build();
    } else {
      return new Response.Builder()
        .setStatusCode(UNAUTHORIZED)
        .setHeader("WWW-Authenticate", "Basic")
        .build();
    }
  }

  public String toHtmlList() {
    FileHandler log = new FileHandler(Config.logger.logFile);
    String[] logs = new String(log.readContent()).split("\\n");
    ArrayList<String> list = new ArrayList<>(Arrays.asList(logs));
    return Formatter.htmlList(list);
  }
}
