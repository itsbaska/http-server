package Config;

public enum Method {
  GET,
  POST,
  OPTIONS;

  public static Method toMethod(String stringMethod) {
    switch (stringMethod) {
      case "GET":
        return GET;
      case "POST":
        return POST;
      case "OPTIONS":
        return OPTIONS;
      default:
        throw new Error();
    }
  }
}
