package application.controller.Handler;

import application.config.Config;
import server.Directory.Formatter;
import server.Directory.Layouts;
import server.Directory.Directory;
import server.Request.Request;
import server.Response.Response;

import static server.utils.StatusCode.OK;

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