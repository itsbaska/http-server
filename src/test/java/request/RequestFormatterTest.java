package request;

import Request.RequestFormatter;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestFormatterTest {
  private String CRLF = "\r\n";
  private String request = "POST /echo HTTP/1.1" + CRLF +
    "cache-control: no-cache" + CRLF +
    "Postman-Token: b952779f-f287-4e75-99cb-750c4545bfa3" + CRLF +
    "Content-Type: text/plain" + CRLF +
    "User-Agent: PostmanRuntime/7.1.5" + CRLF +
    "Accept: */*" + CRLF +
    "Host: 127.0.0.1:3000" + CRLF +
    "accept-encoding: gzip, deflate" + CRLF +
    "content-length: 4" + CRLF +
    "Connection: keep-alive" + CRLF + CRLF +
    "hello";

  @Test
  public void testRequestBody() {
    assertEquals(RequestFormatter.body(request), "hello");
  }

  @Test
  public void testRequestMethod() {
    assertEquals(RequestFormatter.method(request), "POST");
  }

  @Test
  public void testRequestPath() {
    assertEquals(RequestFormatter.path(request), "/echo");
  }

  @Test
  public void testRequestPath2() {
    assertNotEquals(RequestFormatter.path(request), "/bar");
  }

  @Test
  public void testRequestHeaders() {
    assertEquals(RequestFormatter.headers(request).toString(), "{methodLine=POST /echo HTTP/1.1, content-length=4, Accept=*/*, User-Agent=PostmanRuntime/7.1.5, Connection=keep-alive, Postman-Token=b952779f-f287-4e75-99cb-750c4545bfa3, Host=127.0.0.1:3000, cache-control=no-cache, accept-encoding=gzip, deflate, Content-Type=text/plain}");
  }
}