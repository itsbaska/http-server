package Request;

import org.junit.Test;

import static utils.Method.POST;
import static org.junit.Assert.*;

public class RequestTest {
  private String CRLF = "\r\n";

  @Test
  public void testRequest() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals("POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye", request.fullRequestText);
  }

  @Test
  public void testRequestBody() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals("goodbye", request.body);
  }

  @Test
  public void testRequestNoBody() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals("", request.body);
  }

  @Test
  public void testRequestMethod() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals(POST, request.method);
  }

  @Test
  public void testRequestPath() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF +
      "goodbye";
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals("/echo", request.path);
  }

  @Test
  public void testGetHeaders() {
    String incomingRequest = "POST /echo HTTP/1.1" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Content-length: 7" + CRLF + CRLF;
    Request request = new Request.Builder().build(incomingRequest);
    assertEquals("text/plain", request.getHeader("Content-Type"));

  }
}