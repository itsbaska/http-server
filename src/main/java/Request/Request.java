package Request;

public class Request {

  public String get () {
    String CRLF = "\r\n";
    return "GET /echo HTTP/1.1" + CRLF +
      "cache-control: no-cache" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Accept: */*" + CRLF +
      "Host: 127.0.0.1:3000" + CRLF +
      "accept-encoding: gzip, deflate" + CRLF +
      "Connection: keep-alive" + CRLF + CRLF;
  }

  public String post (String path, String body) {
    String CRLF = "\r\n";
    return "POST / HTTP/1.1" + CRLF +
      "Host: 127.0.0.1" + path + CRLF +
      "Content-Type: application/x-www-form-urlencoded" + CRLF +
      "Content-Length: " + body.length() + CRLF +CRLF +
      body;
  }
}
