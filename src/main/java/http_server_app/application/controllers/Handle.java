package http_server_app.application.controllers;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;

public interface Handle {
  Response get(Request request);
  Response post(Request request);
  Response put(Request request);
  Response patch(Request request);
  Response options(Request request);
  Response head(Request request);
  Response delete(Request request);
}
