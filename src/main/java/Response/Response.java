package Response;

public class Response {
  private String Body;

  String CRLF = "\r\n";
  public String status200(String content) {
    String headers = "HTTP/1.1 200" + CRLF +
      "Content-Length: " + (content).length() + CRLF +
      "Connection: close" + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      content;
    return headers;
  }
}
