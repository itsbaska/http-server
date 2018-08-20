package Config;

public enum Method {
  GET,
  POST, 
  PUT,
  OPTIONS;

  public static Method toMethod(String stringMethod) {
    switch (stringMethod) {
      case "GET":
        return GET;
      case "POST":
        return POST;
      case "OPTIONS":
        return OPTIONS;
      case "PUT":
        return PUT;
      default:
        throw new Error();
    }
  }
}
