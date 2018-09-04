package Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ResponseTest {

  @Test
  public void testResponseStringifyWithHeaders() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setHeader("Allow", "GET")
      .setStatusCode(200)
      .build();
    assertEquals(new String(response.responseBytes()), "HTTP/1.1 200\r\nAllow: GET\r\n\r\nhello");
  }

  @Test
  public void testResponseWithoutBody() {
    Response response = new Response.Builder()
      .setHeader("Allow", "GET")
      .setStatusCode(200)
      .build();
    assertNull(response.body);
  }

  @Test
  public void testResponseBody() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setStatusCode(200)
      .build();
    assertEquals(new String(response.body), "hello");
  }

  @Test
  public void testResponseStatusCode() {
    Response response = new Response.Builder()
      .setBody("hello".getBytes())
      .setStatusCode(200)
      .build();
    assertEquals(response.statusCode, 200);
  }
}