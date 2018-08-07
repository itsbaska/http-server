package Config;

public class Route {
  public String method;
  public String path;

  public Route(String method, String path) {
    this.method = method;
    this.path = path;
  }

  public String method() {
    return this.method;
  }

  public String path() {
    return this.path;
  }
}
