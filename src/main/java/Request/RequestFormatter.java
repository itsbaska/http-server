package Request;

import java.util.HashMap;

public class RequestFormatter {
  public static String body(String requestString) {
    String request[] = requestString.split("\\r\\n\\r\\n");
    if (request.length == 1) {
      return "";
    } else {
      return request[1];
    }
  }
  public static HashMap<String, String> headers(String requestString) {
    String request[] = requestString.split("\\r\\n\\r\\n");
    String requestHeaders[] = request[0].split(": |\\r\\n");

    HashMap<String, String> parsedHeaders = new HashMap<>();
    parsedHeaders.put("methodLine", requestHeaders[0]);

    for(int i = 1; i < requestHeaders.length - 1; i+=2) {
      parsedHeaders.put(requestHeaders[i], requestHeaders[i+1]);
    }
    return parsedHeaders;
  }
  public static String method(String requestString) {
    String requestHeaders[] = requestString.split(": |\\r\\n");
    return requestHeaders[0].split(" ")[0];
  }

  public static String path(String requestString) {
    String requestHeaders[] = requestString.split(": |\\r\\n");
    return requestHeaders[0].split(" ")[1];
  }
}
