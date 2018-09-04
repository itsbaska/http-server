package server.Request;

import java.util.Base64;

public class Credential {

  private final String username;
  private final String password;

  public Credential(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean isAuthorized(Request request) {
    String credentials = request.getHeader("Authorization");
    return requestIsAuthorized(parseCredentials(credentials));
  }

  private String parseCredentials(String credentials) {
    String[] cred = credentials.split(" ");
    if (cred.length == 2) return cred[1];
    return cred[0];
  }

  private boolean requestIsAuthorized(String credentials) {
    return encode().equals(credentials);
  }

  public String encode() {
    String validAuthorization = username + ":" + password;
    return Base64.getEncoder().encodeToString(validAuthorization.getBytes());
  }
}
