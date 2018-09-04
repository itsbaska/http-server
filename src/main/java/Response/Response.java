package Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response {
  public HashMap<String, String> headers;
  public int statusCode;
  public byte[] body;
  private String CRLF = "\r\n";


  public Response(Builder builder) {
    this.statusCode = builder.statusCode;
    this.body = builder.body;
    this.headers = builder.headers;
  }

  private String stringify() {
    return "HTTP/1.1 " + this.statusCode + CRLF +
      formatHeaders(headers) + CRLF;
  }

  public byte[] responseBytes() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
      outputStream.write(stringify().getBytes());
      outputStream.write(body == null ? "".getBytes() : body);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return outputStream.toByteArray();
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
    private byte[] body;
    private HashMap<String, String> headers = new HashMap<>();

    public Builder setStatusCode(int code) {
      this.statusCode = code;
      return this;
    }

    public Builder setHeader(String header, String value) {
      headers.put(header, value);
      return this;
    }

    public Builder setBody(byte[] body) {
      this.body = body;
      return this;
    }

    public Response build() {
      return new Response(this);
    }
  }
}