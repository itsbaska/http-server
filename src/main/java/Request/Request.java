package Request;

import Config.Config;
import Directory.FileHandler;
import utils.Method;

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

  public String getHeader(String header) {
    String[] requestLines = fullRequestText.split("\\r\\n");
    String headerValue = "";
    for (String line : requestLines) {
      if (line.contains(header)) {
        headerValue = line.split(": ")[1];
      }
    }
    return headerValue;
  }

  private String getRequestLine() {
    return fullRequestText.split("\\r\\n")[0];
  }

  public void log() {
    FileHandler logger = new FileHandler(Config.logger.logFile);
    logger.addContent(getRequestLine() + "\n");
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
