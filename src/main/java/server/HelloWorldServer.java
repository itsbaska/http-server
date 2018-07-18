package server;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import java.io.*;
import java.net.*;
import java.io.File;

public class HelloWorldServer {
  public int PORT = 3000;

  public void go() {
    ServerSocket serverSocket = createSocket();
    while (true) {
      Socket socket = listenSocketServer(serverSocket);
      listenSocketBufferedReader(socket, "./content/hello-world.html");
      closeSocket(socket);
    }
  }

  public void closeSocket(Socket socket) {
    try {
      socket.close();
    } catch (IOException e) {
      System.out.println("Closing socket failed");
      System.exit(-1);
    }
  }

  public void listenSocketBufferedReader(Socket socket, String file) {
    OutputStream outputStream = null;
//        InputStream inputStream = null;
    try {
      outputStream = socket.getOutputStream();
//        inputStream = socket.getInputStream();
      outputStream.write((setHeaders(file) + getHtmlContent(file)).getBytes("UTF-8"));
      outputStream.flush();
    } catch (IOException e) {
      System.out.println("Read failed");
      System.exit(-1);
    }
  }

  public Socket listenSocketServer(ServerSocket serverSocket) {
    Socket socket2 = null;
    try {
      System.out.println("got a request");
      socket2 = serverSocket.accept();
    } catch (IOException ex) {
      System.out.println("Accept failed: " + PORT);
      System.exit(-1);
    }
    return socket2;
  }

  public ServerSocket createSocket() {
    ServerSocket serverSocket2 = null;
    try {
      serverSocket2 = new ServerSocket(PORT);
    } catch (IOException ex) {
      System.out.println("Could not listen on port " + PORT);
      ex.printStackTrace();
      System.exit(-1);
    }
    System.out.println(serverSocket2);
    return serverSocket2;
  }

  public String getHtmlContent(String filename) {
    String response = "";
    String line;

    try {
      File helloWorld = new File(filename);
      BufferedReader reader = new BufferedReader(new FileReader(helloWorld));
      try {
        while ((line = reader.readLine()) != null) {
          response += line;
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } catch (FileNotFoundException exception) {
      System.out.println(exception);
      response = get404Content();
    }
    return response;
  }

  public String setHeaders(String file) {
    String headers = "HTTP/1.1 200 OK\r\n" +
      "Content-Length: " +
      getHtmlContent(file).length() + "\r\n" +
      "Content-Type: text/html\r\n\r\n";
    return headers;
  }

  public String get404Content() {
    return getHtmlContent("./content/404.html");
  }
}