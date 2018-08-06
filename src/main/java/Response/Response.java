package Response;

public class Response {
  public int statusCode;
  public int contentLength;
  public String body;
  public String text;

  public Response(int statusCode, String body, int contentLength) {
    String CRLF = "\r\n";
    this.statusCode = statusCode;
    this.body = body;
    this.contentLength = contentLength;
    this.text =
      "HTTP/1.1 " + this.statusCode + CRLF +
        "Content-Length: " + this.contentLength + CRLF +
        "Content-Type: text/html" + CRLF + CRLF +
        this.body;
  }

  public static class Builder {
    private int statusCode;
    private int contentLength;
    private String body;


    public Builder setStatusCode(int code) {
      this.statusCode = code;
      return this;
    }

    public Builder setContentLength() {
      this.contentLength = this.body.length();
      return this;
    }

    public Builder setbody(String body) {
      this.body = body;
      return this;
    }

    public Response build() {
      return new Response(statusCode, body, contentLength);
    }
  }
}