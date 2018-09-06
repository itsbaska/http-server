package application.controller.Handler;

import http_server_app.application.controller.Handler.NotFoundHandler;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotFoundHandlerTest {
  @Test
  public void testNotFoundStatusCodeToBe405() {
    Response response = new NotFoundHandler().get();
    assertEquals(404, response.status.code);
  }
}