package Request;

import java.util.HashMap;

public class Request {
  private String RequestString;
  public Request(String request) {
    RequestString = request;
  }
  public String body() {
    String request[] = RequestString.split("\\r\\n\\r\\n");
    return request[1];
  }
  public HashMap<String, String> headers() {
    String request[] = RequestString.split("\\r\\n\\r\\n");
    String requestHeaders[] = request[0].split(": |\\r\\n");

    HashMap<String, String> parsedHeaders = new HashMap<>();
    parsedHeaders.put("methodLine", requestHeaders[0]);

    for(int i = 1; i < requestHeaders.length - 1; i+=2) {
      parsedHeaders.put(requestHeaders[i], requestHeaders[i+1]);
    }
    return parsedHeaders;
  }
  public String method() {
    String requestHeaders[] = RequestString.split(": |\\r\\n");
    return requestHeaders[0].split(" ")[0];
  }

  public String path() {
    String requestHeaders[] = RequestString.split(": |\\r\\n");
    return requestHeaders[0].split(" ")[1];
  }
}
