package Router.Handler.StaticHandlers;

import Directory.FileHandler;
import Request.Request;
import Response.Response;
import Router.Handler.Handler;

import java.io.File;

import static Config.Config.publicDirectory;

public class POSTFileHandler extends Handler {

  public POSTFileHandler(String fileName) {
    this.fileName = fileName;
  }

  public Response handle(Request request) {
    FileHandler file = new FileHandler(new File(publicDirectory.getPath() + "/" + fileName));
    file.addContent(request.body);
    return new Response.Builder()
      .setStatusCode(200)
      .setBody(new String(file.readContent()))
      .build();
  }
}
