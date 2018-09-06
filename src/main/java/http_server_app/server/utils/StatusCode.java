package http_server_app.server.utils;
public enum StatusCode {
  OK(200, "OK"),
  CREATED(201, "Created"),
  ACCEPTED(202, "Accepted"),
  NO_CONTENT(204, "No Content"),
  PARTIAL_CONTENT(206, "Partial Content"),
  FOUND(302, "Found"),
  UNAUTHORIZED(401, "Unauthorized"),
  NOT_FOUND(404, "Not Found"),
  NOT_ALLOWED(405, "Method Not Allowed");


  public int code;
  public String text;

  StatusCode(int code, String text) {
    this.code = code;
    this.text = text;
  }

  public String toString() {
    return Integer.toString(this.code) + " " + this.text;
  }
}
