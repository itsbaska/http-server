package Response;

import java.util.HashMap;

public class Response {
  private String ResponseString;

  public Response(String response) {
    ResponseString = response;
  }

  public String body() {
    String response[] = ResponseString.split("\\r\\n\\r\\n");
    if (response.length == 1) {
      return "";
    } else {
      return response[1];
    }
  }

  public HashMap<String, String> headers() {
    String response[] = ResponseString.split("\\r\\n\\r\\n");
    String responseHeaders[] = response[0].split(": |\\r\\n");

    HashMap<String, String> parsedHeaders = new HashMap<>();
    parsedHeaders.put("methodLine", responseHeaders[0]);

    for (int i = 1; i < responseHeaders.length - 1; i += 2) {
      parsedHeaders.put(responseHeaders[i], responseHeaders[i + 1]);
    }
    return parsedHeaders;
  }


  public String status() {
    String responseHeaders[] = ResponseString.split(": |\\r\\n");
    return responseHeaders[0].split(" ")[1];
  }

  public String path() {
    String responseHeaders[] = ResponseString.split(": |\\r\\n");
    return responseHeaders[0].split(" ")[1];
  }

}
