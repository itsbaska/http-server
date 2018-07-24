//package server;
//
//import Response.Response;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//
//import static org.junit.Assert.*;
//
//public class ServerTest {
//
////  @Test
//  public void testServerOpenSocket() {
//    Server server = new Server();
////    assertEquals(TestableSocket.testSocket(), server.clientSocket(server.createSocket()));
//  }
//
//  private static class TestableSocket {
//    public static ByteArrayInputStream testSocket() {
//      return new ByteArrayInputStream("some string I want to test".getBytes());
//    }
//    public boolean serverIsRunning() {
//      Server server = new Server();
//      try (ServerSocket s = server.createSocket()) {
//        return true;
//      } catch (IOException ex) {
//        /* ignore */
//      }
//      return false;
//    }
//  }
//
//  @Test
//  public void testServerGetsHeaders() {
//    Response response = new Response();
//    assertEquals("HTTP/1.1 200 OK\r\n" +
//      "Content-Length: 150\r\n" +
//      "Content-Type: text/html\r\n\r\n", response.res200("./content/hello-world.html"));
//  }
//
////  @Test
////  public void testServerReadsFile() {
////    Response response = new Response();
////
////    assertEquals("<!DOCTYPE html>" +
////      "<html lang=\"en\">" +
////      "<head>" +
////      "    <meta charset=\"UTF-8\">" +
////      "    <title>Title</title>" +
////      "</head>" +
////      "<body>" +
////      "    <div><h1>Hello World!</h1></div>" +
////      "</body>" +
////      "</html>", response.getHtmlContent("./content/hello-world.html"));
////  }
//}
