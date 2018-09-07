package http_server_app;

import http_server_app.application.config.Config;
import http_server_app.server.Server;

import java.io.IOException;

public class StartServer {
  public static void main(String[] args) throws IOException {
    String port = Config.setPort(args);
    new Server(port).run();
  }
}
