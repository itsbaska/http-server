package application.controller;

import http_server_app.application.controllers.OPTIONS2Handler;
import http_server_app.application.controllers.OPTIONSHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static http_server_app.server.utils.StatusCode.OK;
import static org.junit.Assert.assertEquals;

public class OPTIONSHandlerTest {
  @Test
  public void testOPTIONSStatusCodeToBe200() {
    String CRLF = "\r\n";

    String requestString = "GET /method_options2 HTTP/1.1" + CRLF;

    Request request = new Request(requestString).build();
    Response response = new OPTIONS2Handler().options(request);
    assertEquals(OK, response.status);
  }

  @Test
  public void testOPTIONSHeaders() {
    String CRLF = "\r\n";

    String requestString = "GET /method_options2 HTTP/1.1" + CRLF;

    Request request = new Request(requestString).build();
    Response response = new OPTIONSHandler().options(request);
    assertEquals("OPTIONS, GET, HEAD, POST, PUT", response.headers.get("Allow"));
  }

}