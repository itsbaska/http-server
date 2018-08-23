import Config.Config;
import Server.Server;

import java.io.IOException;

public class StartServer {
  public static void main(String[] args) throws IOException {
    String port = Config.setPort(args);
    new Server(port).run();
  }
}
