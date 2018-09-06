package application.controller.Handler;

import http_server_app.application.controller.Handler.AUTHHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AUTHHandlerTest {
  @Test
  public void testAuthHandlerBodyToBeEmpty() {
    String requestString =
      "GET http://127.0.0.1:3000/logs HTTP/1.1\r\n"+
        "Authorization: Basic cGFzc3dvcmQ=\r\n";
    Request request = new Request(requestString).build();
    Response body = new AUTHHandler().get(request);
    assertEquals(401, body.status.code);
  }
}