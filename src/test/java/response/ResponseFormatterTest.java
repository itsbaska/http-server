package response;

import Response.*;
import org.junit.Test;

import static Response.ResponseFormatter.*;
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
    assertEquals(status(response), "200");
  }

  @Test
  public void testResponseBody() {
    assertEquals(body(response), "hello");
  }

  @Test
  public void testResponseHeaders() {
    assertEquals(headers(response).toString(), "{methodLine=HTTP/1.1 200, Connection=close, Content-Length=5, Content-Type=text/html}");
  }

}