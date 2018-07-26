package Request;

public class PostRequest {

  public String make (String path, String body) {
    String CRLF = "\r\n";
    return "POST / HTTP/1.1" + CRLF +
      "Host: 127.0.0.1" + path + CRLF +
      "Content-Type: application/x-www-form-urlencoded" + CRLF +
      "Content-Length: " + body.length() + CRLF +CRLF +
      body;
  }
}
