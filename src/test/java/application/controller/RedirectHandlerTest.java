package application.controller;

import http_server_app.application.controllers.RedirectHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedirectHandlerTest {
  @Test
  public void testRedirectStatusCodeToBe302() {
    String requestString = "GET /redirect HTTP/1.1\r\n";
    Request request = new Request(requestString).build();
    Response response = new RedirectHandler().get(request);
    assertEquals(302, response.status.code);
  }

  @Test
  public void testRedirectHeader() {
    String requestString = "GET /redirect HTTP/1.1\r\n";
    Request request = new Request(requestString).build();
    Response response = new RedirectHandler().get(request);
    assertEquals("/", response.headers.get("Location"));

  }

}