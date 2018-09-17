package http_server_app.application.controllers;

import http_server_app.server.Directory.Directory;
import http_server_app.server.Directory.Formatter;
import http_server_app.server.Directory.Layouts;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

import java.io.File;

import static http_server_app.server.utils.StatusCode.OK;

public class DirectoryHandler extends Handler {
  private final File file;

  public DirectoryHandler(File file) {
    this.file = file;
  }
  public Response get(Request request) {
    String htmlDirectoryList = Layouts.html(Formatter.getFileListWithLinks(Directory.getFiles(file)));
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