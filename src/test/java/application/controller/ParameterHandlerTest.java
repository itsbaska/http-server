package application.controller;

import http_server_app.application.controllers.ParameterHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParameterHandlerTest {
  @Test
  public void testParametersBody() {
    String requestString = "GET /parameters?this=that HTTP/1.1\r\n";
    Request request = new Request(requestString).build();
    Response response = new ParameterHandler().get(request);
    assertEquals("[this = that]", new String(response.body));
  }

}