package http_server_app.server.Validator;

import java.io.IOException;
import java.net.Socket;

public class Validator {

  public static boolean validArgsLength(String[] args) {
    if (args.length == 2) {
      return true;
    } else {
      System.err.println("Usage: http_server_app.StartServer [-p] [PORT number]");
      return false;
    }
  }

  public static boolean validFlag(String[] args) {
    if (args[0].equals("-p")) {
      return true;
    } else {
      System.err.println("Usage: http_server_app.StartServer [-p] [PORT number]");
      return false;
    }
  }

  public static boolean portIsNotAvailable(String port) {
    try {
      (new Socket("127.0.0.1", Integer.parseInt(port))).close();
      return true;
    } catch (IOException ignored) {
      return false;
    }
  }
}