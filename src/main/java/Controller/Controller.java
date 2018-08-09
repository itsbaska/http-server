package Controller;
import Config.Handler.GetHandler;
import Config.Handler.HandlerFactory;
import Config.Handler.RequestHandler;
import Request.Request;
import Response.Response;

public class Controller {
  public Response handleRequest(Request request) {
    Response response2 = new Response.Builder()
      .setStatusCode(200)
      .setbody("I am this Response2")
      .build();
    RequestHandler handler = new HandlerFactory().createHandler(request);
    return handler.handleRequest(request, response2);
//
//    Response response = null;
//    switch (request.path) {
//      case "/":
//        switch (request.method) {
//          case GET:
//            response = new Response.Builder()
//              .setStatusCode(200)
//              .setbody("")
//              .build();
//            break;
//        }
//        break;
//      case "/echo":
//        switch (request.method) {
//          case GET:
//            response = new Response.Builder()
//              .setStatusCode(200)
//              .setbody("")
//              .build();
//            break;
//          case POST:
//            response = new Response.Builder()
//              .setStatusCode(200)
//              .setbody(request.body)
//              .build();
//            break;
//        }
//        break;
//    }
//    return response;
  }
}
