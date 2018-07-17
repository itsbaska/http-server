package server;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldServerTest {
    @Test public void testServerGetsHeaders() {
        HelloWorldServer server = new HelloWorldServer();
        assertEquals("HTTP/1.1 200 OK\r\n" +
                "Content-Length: 4\r\n" +
                "Content-Type: text/html\r\n\r\n", server.setHeaders("this"));
    }

    @Test public void testServerReadsFile() {
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
                "</html>", server.getHtmlContent("hello-world.html"));
    }
}
