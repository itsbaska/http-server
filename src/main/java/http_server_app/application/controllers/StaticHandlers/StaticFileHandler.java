package http_server_app.application.controllers.StaticHandlers;

import http_server_app.application.controllers.Handler;
import http_server_app.server.Directory.FileHandler;
import http_server_app.server.Request.Range;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.utils.MimeType;

import java.io.File;

import static http_server_app.server.utils.StatusCode.*;

public class StaticFileHandler extends Handler {
  private File file;

  public StaticFileHandler(File file) {
    this.file = file;
  }

  public Response get(Request request) {
    FileHandler fileHandler = new FileHandler(file);
    String contentRange = request.getHeader("Content-Range");
    if (contentRange != "") return range(fileHandler, contentRange);
    else {
      return new Response.Builder()
        .setStatusCode(OK)
        .setHeader("Content-type", MimeType.getType(fileHandler.getFileExtension()))
        .setBody(fileHandler.readContent())
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
    FileHandler fileHandler = new FileHandler(file);
    fileHandler.updateContent(request.body);
    return new Response.Builder()
      .setStatusCode(NO_CONTENT)
      .build();
  }
}
