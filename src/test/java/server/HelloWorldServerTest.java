package server;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class HelloWorldServerTest {
//  @Test
//  public void testCreateSocket() {
//    HelloWorldServer server = new HelloWorldServer();
//    assertEquals(, server.createSocket());
//  }

  @Test
  public void testServerOpenSocket() {
    HelloWorldServer server = new HelloWorldServer();

//    new TestableSocket(new ByteArrayInputStream("some string I want to test".getBytes())

    assertEquals(TestableSocket.testSocket(), server.clientSocket(server.createSocket()));
  }

  private static class TestableSocket {
    public static ByteArrayInputStream testSocket() {
      return new ByteArrayInputStream("some string I want to test".getBytes());
    }
  }

  @Test
  public void testServerGetsHeaders() {
    HelloWorldServer server = new HelloWorldServer();
    assertEquals("HTTP/1.1 200 OK\r\n" +
      "Content-Length: 150\r\n" +
      "Content-Type: text/html\r\n\r\n", server.setResponseHeaders("./content/hello-world.html"));
  }

  @Test
  public void testServerReadsFile() {
    HelloWorldServer server = new HelloWorldServer();
    assertEquals("<!DOCTYPE html>" +
      "<html lang=\"en\">" +
      "<head>" +
      "    <meta charset=\"UTF-8\">" +
      "    <title>Title</title>" +
      "</head>" +
      "<body>" +
      "    <div><h1>Hello World!</h1></div>" +
      "</body>" +
      "</html>", server.getHtmlContent("./content/hello-world.html"));
  }
}
