package application.controller.Handler;

import org.junit.Test;
import server.Response.Response;

import static org.junit.Assert.*;

public class NotFoundHandlerTest {
  @Test
  public void testNotFoundStatusCodeToBe405() {
    Response response = new NotFoundHandler().get();
    assertEquals(404, response.status.code);
  }
}