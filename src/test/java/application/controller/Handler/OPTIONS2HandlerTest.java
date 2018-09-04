package application.controller.Handler;

import org.junit.Test;
import server.Request.Request;
import server.Response.Response;

import static org.junit.Assert.assertEquals;
import static server.utils.StatusCode.OK;

public class OPTIONS2HandlerTest {
  @Test
  public void testOPTIONS2StatusCodeToBe200() {
    String requestString = "GET /method_options2 HTTP/1.1\r\n";
    Request request = new Request(requestString).build();
    Response response = new OPTIONSHandler().options(request);
    assertEquals(OK, response.status);
  }

  @Test
  public void testOPTIONSHeaders() {
    String requestString = "GET /method_options2 HTTP/1.1\r\n";
    Request request = new Request(requestString).build();
    Response response = new OPTIONS2Handler().options(request);
    assertEquals("OPTIONS, GET", response.headers.get("Allow"));
  }
}