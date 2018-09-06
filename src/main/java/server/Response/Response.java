package server.Response;

import server.utils.StatusCode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response {
  public HashMap<String, String> headers;
  public StatusCode status;
  public byte[] body;
  private static final String CRLF = "\r\n";
  private static final String PROTOCOL = "HTTP/1.1";

  public Response(Builder builder) {
    this.status = builder.status;
    this.body = builder.body;
    this.headers = builder.headers;
  }

  private byte[] statusLine() {
    return (PROTOCOL + " " + status.toString() + CRLF).getBytes();
  }

  private byte[] headers() {
    return (formatHeaders(headers) + CRLF).getBytes();
  }

  public byte[] responseBytes() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
      outputStream.write(statusLine());
      outputStream.write(headers());
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
    private StatusCode status;
    private byte[] body;
    private HashMap<String, String> headers = new HashMap<>();

    public Builder setStatusCode(StatusCode code) {
      this.status = code;
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