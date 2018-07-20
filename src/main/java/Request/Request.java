package Request;

public class Request {
  public String requestGet(String method, String path) {
    return method + " " + path + " HTTP/1.1\r\n";
  }

  public String requestPost(String method, String path, String data) {
    return method + " " + path + " HTTP/1.1\r\n" +
      "Host: 127.0.0.1\n" +
      "Content-Type: application/x-www-form-urlencoded\n" +
      "Content-Length: " + data.length() + "\n" +
      "\n" +
      data;
  }
}
