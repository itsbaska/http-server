package Validator;

public class Validator {

  public static boolean validArgsLength(String[] args) {
    if (args.length == 2) {
      return true;
    } else {
      System.err.println("Usage: StartServer [-p] [PORT number]");
      return false;
    }
  }

  public static boolean validFlag(String[] args) {
    if (args[0].equals("-p")) {
      return true;
    } else {
      System.err.println("Usage: StartServer [-p] [PORT number]");
      return false;
    }
  }
}