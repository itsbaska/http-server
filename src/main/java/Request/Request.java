package Request;

import Config.Config;
import Directory.FileHandler;
import utils.Method;

import java.util.HashMap;

public class Request {
  public Method method;
  public String path;
  public String body;
  public String request;
  private String rawParameter;
  public HashMap<String, String> parameters;
  private boolean hasParameter;

  public Request(String request) {
    this.request = request;
  }

  public String getHeader(String header) {
    String[] requestLines = request.split("\\r\\n");
    String headerValue = "";
    for (String line : requestLines) {
      if (line.contains(header)) {
        headerValue = line.split(": ")[1];
      }
    }
    return headerValue;
  }

  private String getRequestLine() {
    return request.split("\\r\\n")[0];
  }

  public void log() {
    FileHandler logger = new FileHandler(Config.logger.logFile);
    logger.addContent(getRequestLine() + "\n");
  }

  public Request build() {
    setMethod();
    setPath();
    setBody();
    if (hasParameter) {
      setParameter();
    }
    return this;
  }

  private void setMethod() {
    String fullRequest[] = request.split(": |\\r\\n");
    this.method = Method.toMethod(fullRequest[0].split(" ")[0]);
  }

  private void setPath() {
    String fullRequest[] = request.split(": |\\r\\n");
    String potentialPath = Parameters.decodeParameter(fullRequest[0].split(" ")[1]);
    if (hasParameter(potentialPath)) {
      this.path = getPathFromQuery(potentialPath);
      this.rawParameter = getParametersFromQuery(potentialPath);
      this.hasParameter = true;
    } else {
      this.path = potentialPath;
    }
  }

  private void setBody() {
    String fullRequest[] = request.split("\\r\\n\\r\\n");
    if (fullRequest.length == 1) {
      this.body = "";
    } else {
      this.body = fullRequest[1];
    }
  }

  private void setParameter() {
    this.parameters = Parameters.getAllParameters(rawParameter);
  }

  private boolean hasParameter(String path) {
    return path.contains("?");
  }

  private String getPathFromQuery(String query) {
    return query.split("\\?", 2)[0];
  }

  private String getParametersFromQuery(String query) {
    return query.split("\\?", 2)[1];
  }
}
