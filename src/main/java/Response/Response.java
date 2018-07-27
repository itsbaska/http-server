package Response;

import java.util.HashMap;

public class Response {
  private final String status;
  private final HashMap<String, String> headers;
  private final String body;

  public Response(String response) {
    this.status = ResponseFormatter.status(response);
    this.headers = ResponseFormatter.headers(response);
    this.body = ResponseFormatter.body(response);
  }

  public HashMap headers() {
    return headers;
  }

  public String status() {
    return status;
  }

  public String body() {
    return body;
  }
}
