package Request;

public class Request {
  public String requestGet() {
    return "GET /echo HTTP/1.1\r\n";
  }

  public String requestPost(String data) {
    return "POST /echo HTTP/1.1\r\n" +
      "Host: 127.0.0.1\r\n" +
      "Content-Type: application/x-www-form-urlencoded\r\n" +
      "Content-Length: " + (data + "\r\n\r\n").length() + "\r\n\r\n" +
      data +
      "\r\n\r\n";
  }
}
