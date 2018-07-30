package request;

import org.junit.Test;
import Request.Request;
import static org.junit.Assert.*;

public class RequestTest {
    private String CRLF = "\r\n";

  @Test
  public void testRequestBody() {
    String request = "POST /echo HTTP/1.1" + CRLF +
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
    assertEquals("hello", new Request(request).body());
  }

  @Test
  public void testRequestNoBody() {
    String request = "POST /echo HTTP/1.1" + CRLF +
      "cache-control: no-cache" + CRLF +
      "Postman-Token: b952779f-f287-4e75-99cb-750c4545bfa3" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "User-Agent: PostmanRuntime/7.1.5" + CRLF +
      "Accept: */*" + CRLF +
      "Host: 127.0.0.1:3000" + CRLF +
      "accept-encoding: gzip, deflate" + CRLF +
      "content-length: 4" + CRLF +
      "Connection: keep-alive" + CRLF + CRLF;
    Request actual = new Request(request);
    assertEquals("", actual.body());
  }

  @Test
  public void testRequestMethod() {
    String request = "POST /echo HTTP/1.1" + CRLF +
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
    assertEquals("POST", new Request(request).method());
  }

  @Test
  public void testRequestPath() {
    String request = "POST /echo HTTP/1.1" + CRLF +
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
    assertEquals("/echo", new Request(request).path());
  }

}