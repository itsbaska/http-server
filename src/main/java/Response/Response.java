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
    this.contentLength = builder.body.length();
    this.headers = builder.headers;
  }

  public String stringify() {
    String text = "HTTP/1.1 " + this.statusCode + CRLF +
      formatHeaders(this.headers) +
      "Content-Length: " + this.contentLength + CRLF +
      "Content-Type: text/html" + CRLF + CRLF +
      this.body;

    return text;
  }

  private String formatHeaders(HashMap<String, String> headers) {
    Set<Map.Entry<String, String>> headersSet = headers.entrySet();
    String formattedHeader = "";
    for (Map.Entry entry : headersSet) {
      Object header = entry.getKey();
      Object value = entry.getValue();
      formattedHeader += header.toString() + ": " + value.toString() + CRLF;
    }
    System.out.println("Inside formatter");
    System.out.println(formattedHeader);
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

    public Builder setbody(String body) {
      this.body = body;
      return this;
    }

    public Response build() {
      return new Response(this);
    }
  }
}