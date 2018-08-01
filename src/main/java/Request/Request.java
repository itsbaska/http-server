package Request;

public class Request {
  private final String method;
  private final String path;
  private final String body;

  public Request(String request) {
    this.method = RequestFormatter.method(request);
    this.path = RequestFormatter.path(request);
    this.body = RequestFormatter.body(request);
  }

  public String method() {
    return method;
  }

  public String path() {
    return path;
  }

  public String body() {
    return body;
  }
}
