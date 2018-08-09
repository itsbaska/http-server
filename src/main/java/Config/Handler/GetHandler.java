package Config.Handler;
import Request.Request;
import Response.Response;

public class GetHandler implements Handler {
  @Override
  public Response handle(Request request, Response response) {
    System.out.println(request.body + " <<< This is Req body from GET handler");
    return response;
  }
}
