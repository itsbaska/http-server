package gradle.cucumber;

import cucumber.api.java.Before;
import http_server_app.server.Server;
import http_server_app.server.ServerConfig;

public class GlobalHooks {
  private static boolean serverIsRunning = false;
  private Server server;

  @Before("not @port5000")
  public void startServer() {
    if (!serverIsRunning) {
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        server.stop();
        serverIsRunning = false;
      }));
      try {
        server = new Server();
        ServerConfig.setup(server, new String[]{"-p", "3000"});
        Thread thread = new Thread(server);
        thread.start();
        serverIsRunning = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
