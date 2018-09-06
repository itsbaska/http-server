package server;
import application.controller.Handler.MethodNotAllowedHandler;
import application.controller.Controller;
import server.Request.Request;
import server.Response.Response;
import server.utils.InvalidRequestException;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server implements Runnable {
  private final String port;
  private Controller controller = new Controller();
  private boolean running = true;

  public Server(String port) {
    this.port = port;
  }

  private void handleRequest(Socket clientSocket) {
    try {
      Request request;
      Response response;
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
      StringBuilder requestBuilder = new StringBuilder();
      while (in.ready() || requestBuilder.length() == 0) {
        requestBuilder.append((char) in.read());
      }
      try {
        request = new Request(requestBuilder.toString()).build();
        response = controller.handleRequest(request);
      } catch (InvalidRequestException e) {
        response = new MethodNotAllowedHandler().getResponse();
      }
      DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
      out.write(response.responseBytes());
      out.flush();
      out.close();
      in.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println("Read failed");
      System.exit(-1);
    }
  }



  public void stop() {
    this.running = false;
  }

  @Override
  public void run() {
    try {
      System.out.println("Starting server on PORT: " + port);
      ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));

      while (running) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("\nAccepted connection from testClient: " + clientSocket.getRemoteSocketAddress());

        handleRequest(clientSocket);

        clientSocket.close();
        System.out.println("\nClosing connection with testClient: " + clientSocket.getInetAddress());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
