package Controller;
import Config.Routes.Route;
import Controller.Handler.HandlerFactory;
import Controller.Handler.RequestHandler;
import Controller.Matcher.Matcher;
import Request.Request;
import Response.Response;

public class Controller {
  public Response handleRequest(Request request) {
    Response response2 = new Response.Builder()
      .setStatusCode(200)
      .setbody("I am this Response2")
      .build();
    RequestHandler handler = new HandlerFactory().createHandler(request);

    Route route = Matcher.getRoute(request);

    return handler.handleRequest(request, response2); // this returns a response object

    
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
