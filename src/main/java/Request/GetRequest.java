package Request;

public class GetRequest extends Request {
  public String request(String path) {
    return "GET " + path + " HTTP/1.1\r\n";
  }
}
