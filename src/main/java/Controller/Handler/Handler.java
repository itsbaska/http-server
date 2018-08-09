package Controller.Handler;
import Request.Request;
import Response.Response;

public interface Handler {
  Response handle(Request request, Response response);
}
