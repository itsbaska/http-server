package request;

import Request.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestTest {
  String CRLF = "\r\n";
  Request request = new Request("POST /echo HTTP/1.1" + CRLF +
    "cache-control: no-cache" + CRLF +
    "Postman-Token: b952779f-f287-4e75-99cb-750c4545bfa3" + CRLF +
    "Content-Type: text/plain" + CRLF +
    "User-Agent: PostmanRuntime/7.1.5" + CRLF +
    "Accept: */*" + CRLF +
    "Host: 127.0.0.1:3000" + CRLF +
    "accept-encoding: gzip, deflate" + CRLF +
    "content-length: 4" + CRLF +
    "Connection: keep-alive" + CRLF + CRLF +
    "hello");
  @Test
  public void testRequestBody() {
    assertEquals(request.body(), "hello");
  }

  @Test
  public void testRequestMethod() {
    assertEquals(request.method(), "POST");
  }

  @Test
  public void testRequestPath() {
    assertEquals(request.path(), "/echo");
  }

  @Test
  public void testRequestHeaders() {
    assertEquals(request.headers().toString(), "{methodLine=POST /echo HTTP/1.1, content-length=4, Accept=*/*, User-Agent=PostmanRuntime/7.1.5, Connection=keep-alive, Postman-Token=b952779f-f287-4e75-99cb-750c4545bfa3, Host=127.0.0.1:3000, cache-control=no-cache, accept-encoding=gzip, deflate, Content-Type=text/plain}");
  }
}
