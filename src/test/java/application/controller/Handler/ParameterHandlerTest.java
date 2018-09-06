package application.controller.Handler;

import org.junit.Test;
import server.Request.Request;
import server.Response.Response;

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