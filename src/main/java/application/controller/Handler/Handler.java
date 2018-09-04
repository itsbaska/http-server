package application.controller.Handler;

import server.Request.Request;
import server.Response.Response;

public abstract class Handler implements Handle {
  protected String fileName;

  public Response get(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response post(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response put(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response patch(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response delete(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response head(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }

  public Response options(Request request) {
    return new MethodNotAllowedHandler().getResponse();
  }
}
