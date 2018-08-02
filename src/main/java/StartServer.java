import server.Server;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import static Validator.Validator.*;

public class StartServer {
  public static void main(String[] args) throws IOException {
    if (validArgsLength(args) && validFlag(args)) {
      String port = args[1];
        if (portIsAvailable(port)) {
          System.err.println("PORT: " + port + " is already in use.");
        } else {
          System.out.println("PORT: " + port);
          System.out.println("Success!");
          new Server().go(port);
        }
    }
  }

  public static boolean portIsAvailable(String port) throws IOException {
    try {
      (new Socket("127.0.0.1", Integer.parseInt(port))).close();
      return true;
    } catch (SocketException ignored) {
      return false;
    }
  }
}
