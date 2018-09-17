package http_server_app;

import http_server_app.server.Server;
import http_server_app.server.ServerConfig;

public class StartServer {
  public static void main(String[] args) {
    Server server = new Server();
    ServerConfig.setup(server, args);
    server.run();
  }
}
