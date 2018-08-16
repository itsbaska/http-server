package Config;

public enum Method {
  GET,
  POST,
  PUT;

  public static Method toMethod(String stringMethod) {
    switch (stringMethod) {
      case "GET":
        return GET;
      case "POST":
        return POST;
      case "PUT":
        return PUT;
      default:
        throw new Error();
    }
  }
}
