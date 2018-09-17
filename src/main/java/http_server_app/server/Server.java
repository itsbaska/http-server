package http_server_app.server;

import http_server_app.server.Routes.Controller;
import http_server_app.server.Routes.Routes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

import static http_server_app.server.ServerConfig.DEFAULT_PORT;
import static http_server_app.server.Validator.Validator.*;

public class Server implements Runnable {
  private int port;
  public Routes routes;
  private boolean running = true;
  public Controller controller;

  public void setPort(String[] args) {
    this.port = DEFAULT_PORT;
    if (validArgsLength(args) && validFlag(args)) {
      String chosenPort = args[1];
      if (portIsNotAvailable(chosenPort)) {
        System.err.println("PORT: " + chosenPort + " is already in use.");
        System.exit(1);
      } else {
        System.out.println("PORT: " + chosenPort);
        System.out.println("Success!");
        this.port = Integer.parseInt(chosenPort);
      }
    }
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  public void stop() {
    this.running = false;
  }

  @Override
  public void run() {
    try {
      System.out.println("Starting server on PORT: " + port);
      ServerConfig.logger.log("INFO", "Starting server on PORT: " + port);
      ServerSocket serverSocket = new ServerSocket(port);
      while (running) {
        Socket clientSocket = serverSocket.accept();
        CompletableFuture.runAsync(() -> new Connection(clientSocket).run());
      }
    } catch (IOException e) {
      ServerConfig.logger.log("ERROR", e.getMessage());
      e.printStackTrace();
    }
  }
}
