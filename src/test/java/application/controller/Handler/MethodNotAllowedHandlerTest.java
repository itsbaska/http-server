package application.controller.Handler;

import org.junit.Test;
import server.Response.Response;

import static org.junit.Assert.assertEquals;

public class MethodNotAllowedHandlerTest {
  @Test
  public void testMethodNotAllowedStatusCodeToBe405() {
    Response response = new MethodNotAllowedHandler().getResponse();
    assertEquals(405, response.status.code);
  }
}