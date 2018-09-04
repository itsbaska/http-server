package Router.Handler.StaticHandlers;

import Directory.FileHandler;
import Directory.Range;
import Request.Request;
import Response.Response;
import Router.Handler.Handler;

import java.io.File;

import static Config.Config.publicDirectory;

public class GETFileHandler extends Handler {
  public GETFileHandler(String fileName) {
    this.fileName = fileName;
  }

  public Response getResponse(Request request) {
    FileHandler file = new FileHandler(new File(publicDirectory.getPath() + "/" + fileName));
    String contentRange = request.getHeader("Content-Range");
    if (contentRange != null && !contentRange.equals("")) {
      byte[] partialContent = Range.getContent(file.readContent(), contentRange);
      return new Response.Builder()
        .setStatusCode(206)
        .setBody(partialContent)
        .build();
    } else {
      return new Response.Builder()
        .setStatusCode(200)
        .setBody(file.readContent())
        .build();
    }
  }
}
