package server.Request;

import org.junit.Test;

import static server.utils.Method.POST;
import static org.junit.Assert.*;

public class RequestTest {
  private String CRLF = "\r\n";

  @Test
  public void testRequestBody() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request(incomingRequest).build();
    assertEquals("goodbye", request.body);
  }

  @Test
  public void testRequestNoBody() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF;
    Request request = new Request(incomingRequest).build();
    assertEquals("", request.body);
  }

  @Test
  public void testRequestMethod() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request(incomingRequest).build();
    assertEquals(POST, request.method);
  }

  @Test
  public void testRequestPath() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request(incomingRequest).build();
    assertEquals("/echo", request.path);
  }

  @Test
  public void testGetHeaders() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF;
    Request request = new Request(incomingRequest).build();

    assertEquals("text/plain", request.getHeader("Content-Type"));
  }

  @Test
  public void testRequestParameters() {
    String incomingRequest = "GET /echo?test=test HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request(incomingRequest).build();
    assertEquals("test", request.parameters.get("test"));
  }

  @Test
  public void testRequestMultiParameters() {
    String incomingRequest = "GET /echo?test=test&this=that HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request(incomingRequest).build();
    assertEquals("{test=test, this=that}", request.parameters.toString());
  }
}