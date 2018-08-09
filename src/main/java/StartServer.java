import Config.Config;
import Server.Server;

import java.io.IOException;

public class StartServer {
  public static void main(String[] args) throws IOException {
//    Config config = new Config();
    //    config.createRoutes();
    String port = Config.setPort(args);
    Config.createRoutes();
    new Server().go(port);
  }
}
