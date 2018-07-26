package Response;

public class Response200 {
  private String Body;

  String CRLF = "\r\n";
  public String make(String content) {
    String headers = "HTTP/1.1 200" + CRLF +
      "Content-Length: " + (content).length() + CRLF +
      "Connection: close" + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      content;
    return headers;
  }
}
