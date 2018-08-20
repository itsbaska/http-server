package Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response {
  public HashMap<String, String> headers;
  public int statusCode;
  public int contentLength;
  public String body;
  String CRLF = "\r\n";


  public Response(Builder builder) {
    this.statusCode = builder.statusCode;
    this.body = builder.body;
    this.headers = builder.headers;
  }

  public String stringify() {
    return "HTTP/1.1 " + this.statusCode + CRLF +
      formatHeaders(this.headers) + CRLF +
      setBody(this.body);
  }

  private String setBody(String body) {
    String responseBody = "";
      if (body != null) {
        responseBody =  body;
      }
      return responseBody;
  }

  private String formatHeaders(HashMap<String, String> headers) {
    Set<Map.Entry<String, String>> headersSet = headers.entrySet();
    String formattedHeader = "";
    for (Map.Entry entry : headersSet) {
      Object header = entry.getKey();
      Object value = entry.getValue();
      formattedHeader += header.toString() + ": " + value.toString() + CRLF;
    }
    return formattedHeader;
  }

  public static class Builder {
    private int statusCode;
    private String body;
    private HashMap<String, String> headers = new HashMap<>();

    public Builder setStatusCode(int code) {
      this.statusCode = code;
      return this;
    }

    public Builder setHeader(String header, String value) {
      headers.put(header, value);
      return this;
    }

    public Builder setBody(String body) {
      this.body = body;
      return this;
    }

    public Response build() {
      return new Response(this);
    }
  }
}