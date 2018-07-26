package response;

import Response.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseFormatterTest {

  private String CRLF = "\r\n";
  private String response =
    "HTTP/1.1 200" + CRLF +
      "Content-Length: 5" + CRLF +
      "Connection: close" + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      "hello";

  @Test
  public void testResponseStatus() {
    assertEquals(new Response(response).status(), 200);
  }

  @Test
  public void testResponseBody() {
    assertEquals(new Response(response).body(), "hello");
  }

  @Test
  public void testResponseHeaders() {
    assertEquals(new Response(response).headers().toString(), "{methodLine=HTTP/1.1 200, Connection=close, Content-Length=5, Content-Type=text/html}");
  }

}