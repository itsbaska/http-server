package server.Request;

import java.util.Arrays;

public class Range {
  public static byte[] getContent(byte[] content, String contentRange) {
      if (contentRange.startsWith("-")) {
        return Arrays.copyOfRange(content, content.length - Integer.parseInt(contentRange.substring(1)) + 1, content.length);
      } else if(contentRange.endsWith("-")) {
        return Arrays.copyOfRange(content,  Integer.parseInt(contentRange.substring(0, contentRange.length() -1)), content.length);
      } else {
        return Arrays.copyOfRange(content, Integer.parseInt(contentRange.split("-")[0]), Integer.parseInt(contentRange.split("-")[1]));
      }
  }
}
