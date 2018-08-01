import server.Server;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class StartServer {
  public static void main(String[] args) throws IOException {
    int i = 0;
    if (0 != args.length) {
      if (args[i].equals("-p")) {
        String port = args[i + 1];
        if (portIsAvailable(port)) {
          System.err.println("PORT: " + port + " is already in use.");
        } else {
          System.out.println("PORT: " + port);
          System.out.println("Success!");
          new Server().go(port);
        }
      } else {
        System.err.println("Usage: StartServer [-p] [PORT number]");
      }
    } else {
      System.err.println("Usage: StartServer [-p] [PORT number]");
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
