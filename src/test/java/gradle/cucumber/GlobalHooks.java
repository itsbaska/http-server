package gradle.cucumber;

import server.Server;
import cucumber.api.java.Before;

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
        server = new Server("3000");
        Thread thread = new Thread(server);
        thread.start();
        serverIsRunning = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
