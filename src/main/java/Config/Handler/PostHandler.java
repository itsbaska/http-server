package Config.Handler;
import Request.Request;
import Response.Response;

public class PostHandler implements Handler {
  @Override
  public Response handle(Request request, Response response) {
    System.out.println(request.body + " <<< This is Req body from POST handler");
    return response;
  }
}
