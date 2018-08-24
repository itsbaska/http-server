package gradle.cucumber;

import Server.Server;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class GlobalHooks {
  private static boolean serverIsRunning = false;
  private Server server;

  @After("@port5000")
  public void closeServerOnPort5000() throws IOException {
    Runtime.getRuntime().exec("kill $(lsof -t -i :5000)");
  }

  @Before("not @port5000")
  public void startServer() {
    if (!serverIsRunning) {
      Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
          server.stop();
          serverIsRunning = false;
        }
      });
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
