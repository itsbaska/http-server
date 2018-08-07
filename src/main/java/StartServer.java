import Config.Config;
import Server.Server;

import java.io.IOException;

public class StartServer {
  public static void main(String[] args) throws IOException {
    Config config = new Config();
    //    config.createRoutes();
    String port = config.setPort(args);
    new Server().go(port);
  }
}
