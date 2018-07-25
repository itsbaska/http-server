package Request;

public class PostRequest extends Request {
  public String request(String path, String data) {
    return "POST " + path + " HTTP/1.1\r\n" +
      "Host: 127.0.0.1\r\n" +
      "Content-Type: application/x-www-form-urlencoded\r\n" +
      "Connection: close\r\n" +
      "Content-Length: " + (data + "\r\n\r\n").length() + "\r\n\r\n" +
      data +
      "\r\n\r\n";
  }
}
