package Router.Handler;
import Request.Request;
import Response.Response;

public interface Handle {
  Response getResponse(Request request);
}
