package application.controller.Handler;

import org.junit.Test;
import server.Request.Request;
import server.Response.Response;

import static org.junit.Assert.*;
import static server.utils.StatusCode.OK;

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