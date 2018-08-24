package Request;

import Config.Method;

public class Request {
  public Method method;
  public String path;
  public String body;
  public String fullRequestText;

  public Request(String method, String path, String body, String fullRequestText) {
    this.method = Method.toMethod(method);
    this.path = path;
    this.body = body;
    this.fullRequestText = fullRequestText;
  }


  public static class Builder {
    private String method;
    private String path;
    private String body;
    private String fullRequestText;

    private Builder setMethod() {
      String fullRequest[] = fullRequestText.split(": |\\r\\n");
      this.method = fullRequest[0].split(" ")[0];
      return this;
    }

    private Builder setPath() {
      String fullRequest[] = fullRequestText.split(": |\\r\\n");
      this.path = fullRequest[0].split(" ")[1];
      return this;
    }

    private Builder setBody() {
      String fullRequest[] = fullRequestText.split("\\r\\n\\r\\n");
      if (fullRequest.length == 1) {
        this.body = "";
      } else {
        this.body = fullRequest[1];
      }
      return this;
    }

    public Builder setFullRequest(String fullRequestText) {
      this.fullRequestText = fullRequestText;
      return this;
    }

    public Request build(String fullRequestText) {
      setFullRequest(fullRequestText);
      setBody();
      setMethod();
      setPath();
      return new Request(method, path, body, fullRequestText);
    }
  }
}
