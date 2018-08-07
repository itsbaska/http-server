package Config.Routes;

public enum Method {
  GET,
  POST;

  public static Method toMethod(String stringMethod) {
    switch (stringMethod) {
      case "GET":
        return GET;
      case "POST":
        return POST;
      default:
        throw new Error();
    }
  }
}
