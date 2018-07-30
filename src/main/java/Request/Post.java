package Request;

public class Post {
  private final String requestString;

  public Post(String path, String body) {
    String CRLF = "\r\n";
    this.requestString = "POST / HTTP/1.1" + CRLF +
      "Host: 127.0.0.1" + path + CRLF +
      "Content-Type: application/x-www-form-urlencoded" + CRLF +
      "Content-Length: " + body.length() + CRLF + CRLF +
      body;
  }

  public String request() {
    return requestString;
  }
}
