package server;
import Request.RequestFormatter;
import Response.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {

  private void go() throws IOException {
    int PORT = 3000;
    ServerSocket serverSocket = new ServerSocket(PORT);

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
      PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

      StringBuilder requestBuilder = new StringBuilder();
      while (in.ready() || requestBuilder.length() == 0) {
        requestBuilder.append((char) in.read());
      }
      RequestFormatter request = new RequestFormatter(requestBuilder.toString());
      switch(request.method()) {
        case "GET":
          out.write(new Status200("").response());
          break;
        case "POST":
            out.write(new Status200(request.body()).response());
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

  public static void main(String[] args) throws IOException {
    new Server().go();
  }
}
