package Response;

import java.util.HashMap;

public class ResponseFormatter {

  public static String body(String responseString) {
    String response[] = responseString.split("\\r\\n\\r\\n");
    if (response.length == 1) {
      return "";
    } else {
      return response[1];
    }
  }

  public static HashMap<String, String> headers(String responseString) {
    String response[] = responseString.split("\\r\\n\\r\\n");
    String responseHeaders[] = response[0].split(": |\\r\\n");

    HashMap<String, String> parsedHeaders = new HashMap<>();
    parsedHeaders.put("methodLine", responseHeaders[0]);

    for (int i = 1; i < responseHeaders.length - 1; i += 2) {
      parsedHeaders.put(responseHeaders[i], responseHeaders[i + 1]);
    }
    return parsedHeaders;
  }


  public static String status(String responseString) {
    String responseHeaders[] = responseString.split(": |\\r\\n");
    return responseHeaders[0].split(" ")[1];
  }

}
