package application.controller.Handler;

import org.junit.Test;
import server.Request.Request;
import server.Response.Response;

import static org.junit.Assert.*;

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