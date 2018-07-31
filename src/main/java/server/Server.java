package server;
import Request.RequestFormatter;
import Response.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {

  public void go(String port) throws IOException {
    System.out.println("Starting Server on PORT: " + port);

    ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));

    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("\nAccepted connection from testClient: " + clientSocket.getRemoteSocketAddress());

      handleRequest(clientSocket);

      clientSocket.close();
      System.out.println("\nClosing connection with testClient: " + clientSocket.getInetAddress());
    }
  }

  private void handleRequest(Socket clientSocket) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

      StringBuilder requestBuilder = new StringBuilder();
      while (in.ready() || requestBuilder.length() == 0) {
        requestBuilder.append((char) in.read());
      }

      PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      String requestMethod = RequestFormatter.method(requestBuilder.toString());
      String requestBody = RequestFormatter.body(requestBuilder.toString());
      System.out.println(requestMethod);
      switch(requestMethod) {
        case "GET":
          out.write(new Status200("").response());
          break;
        case "POST":
            out.write(new Status200(requestBody).response());
          break;
        default:
          System.out.println("no match");
      }

      out.flush();
      out.close();
      in.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println("Read failed");
      System.exit(-1);
    }
  }
}
