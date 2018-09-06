package application.controller.Handler;

import http_server_app.application.controller.Handler.FormHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormHandlerTest {
  String CRLF = "\r\n";

  @Test
  public void testPOSTFormStatusCodeToBe201() {
    String requestString = "POST /form HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 5" + CRLF + CRLF +
      "my=data";

    Request request = new Request(requestString).build();
    Response response = new FormHandler().post(request);
    assertEquals(201, response.status.code);
  }

  @Test
  public void testPUTFormStatusCodeToBe202() {
    String requestString = "PUT /form HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 5" + CRLF + CRLF +
      "my=data";

    Request request = new Request(requestString).build();
    Response response = new FormHandler().put(request);
    assertEquals(202, response.status.code);
  }

}