package http_server_app.application.controller.Handler;

import http_server_app.application.config.Config;
import http_server_app.server.Directory.Formatter;
import http_server_app.server.Directory.Layouts;
import http_server_app.server.Directory.Directory;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import static http_server_app.server.utils.StatusCode.OK;

public class RootHandler extends Handler {
  public Response get(Request request) {
    Directory directory = new Directory(Config.publicDirectory);
    String htmlDirectoryList = Layouts.html(Formatter.unorderedList(directory.getFileNames()));
    return new Response.Builder()
      .setStatusCode(OK)
      .setBody(htmlDirectoryList.getBytes())
      .build();
  }

  public Response head(Request request) {
    return new Response.Builder()
      .setStatusCode(OK)
      .build();
  }
}