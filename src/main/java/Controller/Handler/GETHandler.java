package Controller.Handler;

import Directory.DirectoryFormatter;
import Directory.FileHandler;
import Request.Request;
import Response.Response;

public class GETHandler extends Handler {
  public Response handle(Request request) {
    FileHandler fileHandler = new FileHandler("/assets", request.path);
    String list = DirectoryFormatter.list(fileHandler.getFileNames());
    String body = DirectoryFormatter.createHtml(list);
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(body)
      .build();
  }
}