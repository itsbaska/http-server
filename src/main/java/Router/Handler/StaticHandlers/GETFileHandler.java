package Router.Handler.StaticHandlers;

import Directory.FileHandler;
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
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(file.readContent())
      .build();
  }
}
