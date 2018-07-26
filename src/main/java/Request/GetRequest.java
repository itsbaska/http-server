package Request;

public class GetRequest {

  public String make () {
    String CRLF = "\r\n";
    return "GET /echo HTTP/1.1" + CRLF +
      "cache-control: no-cache" + CRLF +
      "Content-Type: text/plain" + CRLF +
      "Accept: */*" + CRLF +
      "Host: 127.0.0.1:3000" + CRLF +
      "accept-encoding: gzip, deflate" + CRLF +
      "Connection: keep-alive" + CRLF + CRLF;
  }
}
