package Response;

public class Response {
  private String response;

  public Response(int code, String content) {
    String CRLF = "\r\n";
    this.response =
      "HTTP/1.1 " + code + CRLF +
      "Content-Length: " + (content).length() + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      content;
  }

  public String response() {
    return response;
  }
}
