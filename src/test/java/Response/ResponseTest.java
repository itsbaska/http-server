package Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseTest {
  @Test
  public void testResponseObject() {
    Response response = new Response(200, "hello");
    assertEquals(response.text, "HTTP/1.1 200\r\n" +
      "Content-Length: 5\r\n" +
      "Content-Type: text/html\r\n" +
      "\r\n" +
      "hello");
  }

  @Test
  public void testResponseText() {
    Response response = new Response.Builder()
      .setbody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.text, "HTTP/1.1 200\r\n" +
      "Content-Length: 5\r\n" +
      "Content-Type: text/html\r\n" +
      "\r\n" +
      "hello");
  }

  @Test
  public void testResponseBody() {
    Response response = new Response.Builder()
      .setbody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.body,"hello");
  }

  @Test
  public void testResponseStatusCode() {
    Response response = new Response.Builder()
      .setbody("hello")
      .setStatusCode(200)
      .build();
    assertEquals(response.statusCode, 200);
  }
}