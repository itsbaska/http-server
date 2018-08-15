package Controller.Handler;
import Request.Request;
import Response.Response;

public interface Handle {
  Response handle(Request request);
}
