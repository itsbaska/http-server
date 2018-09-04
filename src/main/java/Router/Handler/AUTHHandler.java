package Router.Handler;

import Config.Config;
import Directory.FileHandler;
import Directory.Formatter;
import Request.Request;
import Response.Response;

public class AUTHHandler extends Handler {
  public Response getResponse(Request request) {
    FileHandler log = new FileHandler(Config.logger.logFile);
    if (Config.credential.isAuthorized(request)) {
      return new Response.Builder()
        .setStatusCode(200)
        .setBody(Formatter.createHtml(log.toHtmlList()).getBytes())
        .build();
    } else {
      return new Response.Builder()
        .setStatusCode(401)
        .setHeader("WWW-Authenticate", "Basic")
        .build();
    }
  }
}
