package Router.Handler.StaticHandlers;

import Directory.FileHandler;
import Request.Request;
import Response.Response;
import Router.Handler.Handler;

import java.io.File;

import static Config.Config.publicDirectory;

public class PATCHFileHandler extends Handler {
  public PATCHFileHandler(String fileName) {
    this.fileName = fileName;
  }

  public Response getResponse(Request request) {
    FileHandler file = new FileHandler(new File(publicDirectory.getPath() + "/" + fileName));
    file.updateContent(request.body);
    return new Response.Builder()
      .setStatusCode(204)
      .build();
  }
}
