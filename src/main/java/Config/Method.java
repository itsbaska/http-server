package Config;

public enum Method {
  GET,
  POST, 
  PUT,
  OPTIONS,
  HEAD;

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
      case "HEAD":
        return HEAD;
      default:
        throw new Error();
    }
  }
}
