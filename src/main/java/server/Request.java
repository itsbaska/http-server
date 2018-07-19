package server;

public class Request {
  public String request(String method, String path) {
    return method + " " + path + " HTTP/1.1\r\n";
  }
}
