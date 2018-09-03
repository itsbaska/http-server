package utils;

public enum Method {
  GET,
  POST, 
  PUT,
  OPTIONS,
  HEAD,
  DELETE;

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
      case "DELETE":
        return DELETE;
      default:
          throw new InvalidRequestException("Request Method Not Found");
    }
  }
}
