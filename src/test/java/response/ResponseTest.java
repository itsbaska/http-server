package response;

import Request.Request;
import Response.Response;
import Response.Response200;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseTest {

  String CRLF = "\r\n";
  Response response = new Response (
    "HTTP/1.1 200" + CRLF +
    "Content-Length: 5" + CRLF +
    "Connection: close" + CRLF +
    "Content-Type: text/html" + CRLF + CRLF +
    "hello");
  @Test
  public void testResponseBody() {
    assertEquals(response.body(), "hello");
  }


  @Test
  public void testResponseHeaders() {
    assertEquals(response.headers().toString(), "{methodLine=HTTP/1.1 200, Connection=close, Content-Length=5, Content-Type=text/html}");
  }
}
