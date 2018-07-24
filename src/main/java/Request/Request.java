package Request;

public class Request {
  public String request(String method, String path, String data) {
    String request = "";
    if (method == "GET") {
      System.out.println("got here");
      request = method + " " + path + " HTTP/1.1\r\n";
    } else if (method == "POST") {
      request = "POST /echo HTTP/1.1\r\n" +
        "Host: 127.0.0.1\r\n" +
        "Content-Type: raw\r\n" +
        "Connection: close\r\n" +
        "Content-Length: " + (data + "\r\n\r\n").length() + "\r\n\r\n" +
        data +
        "\r\n\r\n";
    }
    return request;
  }
}
