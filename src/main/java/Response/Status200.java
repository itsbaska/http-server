package Response;

public class Status200{
  private String response;

  public Status200(String content) {
    String CRLF = "\r\n";
    this.response =
      "HTTP/1.1 200" + CRLF +
      "Content-Length: " + (content).length() + CRLF +
      "Connection: close" + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      content;
  }

  public String response() {
    return response;
  }
}
