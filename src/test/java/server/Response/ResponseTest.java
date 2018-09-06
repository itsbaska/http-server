package server.Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static server.utils.StatusCode.OK;

public class ResponseTest {

  @Test
  public void testResponseStringifyWithHeaders() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setHeader("Allow", "GET")
      .setStatusCode(OK)
      .build();
    assertEquals(new String(response.responseBytes()), "HTTP/1.1 200 OK\r\nAllow: GET\r\n\r\nhello");
  }

  @Test
  public void testResponseWithoutBody() {
    Response response = new Response.Builder()
      .setHeader("Allow", "GET")
      .setStatusCode(OK)
      .build();
    assertNull(response.body);
  }

  @Test
  public void testResponseBody() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setStatusCode(OK)
      .build();
    assertEquals(new String(response.body), "hello");
  }

  @Test
  public void testResponseStatusCode() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setStatusCode(OK)
      .build();
    assertEquals(200, response.status.code);
  }
}