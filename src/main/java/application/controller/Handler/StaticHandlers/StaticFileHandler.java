package application.controller.Handler.StaticHandlers;

import application.controller.Handler.Handler;
import server.Directory.FileHandler;
import server.Request.Range;
import server.Request.Request;
import server.Response.Response;

import java.io.File;

import static application.config.Config.publicDirectory;
import static server.utils.StatusCode.*;

public class StaticFileHandler extends Handler {
  public StaticFileHandler(String fileName) {
    this.fileName = fileName;
  }

  public Response get(Request request) {
    FileHandler file = new FileHandler(new File(publicDirectory.getPath() + "/" + fileName));
    String contentRange = request.getHeader("Content-Range");
    if (contentRange != "") return range(file, contentRange);
    else {
      return new Response.Builder()
        .setStatusCode(OK)
        .setBody(file.readContent())
        .build();
    }
  }

  public Response range(FileHandler file, String contentRange) {
    byte[] partialContent = Range.getContent(file.readContent(), contentRange);
    return new Response.Builder()
      .setStatusCode(PARTIAL_CONTENT)
      .setBody(partialContent)
      .build();
  }

  public Response patch(Request request) {
    FileHandler file = new FileHandler(new File(publicDirectory.getPath() + "/" + fileName));
    file.updateContent(request.body);
    return new Response.Builder()
      .setStatusCode(NO_CONTENT)
      .build();
  }
}
