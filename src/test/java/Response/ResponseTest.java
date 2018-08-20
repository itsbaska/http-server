package Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseTest {

  @Test
  public void testResponseStringify() {
    Response response = new Response.Builder()
      .setBody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.stringify(), "HTTP/1.1 200\r\n" +
      "Content-Length: 5\r\n" +
      "Content-Type: text/html\r\n" +
      "\r\n" +
      "hello");
  }

  @Test
  public void testResponseStringifyWithHeaders() {
    Response response = new Response.Builder()
      .setBody("hello")
      .setHeader("Allow", "GET")
      .setStatusCode(200)
      .build();
    assertEquals(response.stringify(), "HTTP/1.1 200\r\n" +
      "Allow: GET\r\n" +
      "Content-Length: 5\r\n" +
      "Content-Type: text/html\r\n" +
      "\r\n" +
      "hello");
  }

  @Test
  public void testResponseWithoutBody() {
    Response response = new Response.Builder()
      .setHeader("Allow", "GET")
      .setStatusCode(200)
      .build();
    assertEquals(response.stringify(), "HTTP/1.1 200\r\n" +
      "Allow: GET\r\n" +
      "\r\n");
  }


  @Test
  public void testResponseBody() {
    Response response = new Response.Builder()
      .setBody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.body,"hello");
  }

  @Test
  public void testResponseStatusCode() {
    Response response = new Response.Builder()
      .setBody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.statusCode, 200);
  }
}