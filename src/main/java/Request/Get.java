package Request;

public class Get {
  private final String requestString;

  private String CRLF = "\r\n";

  public Get (String path) {
     this.requestString = "GET " + path + " HTTP/1.1" + CRLF +
      "cache-control: no-cache" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Accept: */*" + CRLF +
      "Host: 127.0.0.1:3000" + CRLF +
      "accept-encoding: gzip, deflate" + CRLF +
      "Connection: keep-alive" + CRLF + CRLF;
  }

  public String request() {
    return requestString;
  }
}
