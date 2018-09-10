package http_server_app.server;

import http_server_app.application.config.Config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class Server implements Runnable {
  private final String port;
  private boolean running = true;

  public Server(String port) {
    this.port = port;
  }

  public void stop() {
    this.running = false;
  }

  @Override
  public void run() {
    try {
      System.out.println("Starting server on PORT: " + port);
      Config.logger.log("INFO", "Starting server on PORT: " + port);
      ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
      while (running) {
        Socket clientSocket = serverSocket.accept();
        CompletableFuture.runAsync(() -> new Connection(clientSocket).run());
      }
    } catch (IOException e) {
      Config.logger.log("ERROR", e.getMessage());
      e.printStackTrace();
    }
  }
}
