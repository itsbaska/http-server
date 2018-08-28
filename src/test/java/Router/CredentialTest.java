package Router;

import Request.Request;
import Request.Credential;
import org.junit.Test;

public class CredentialTest {

  @Test
  public void testIsAuthorized() {
    Credential credential = new Credential("test", "password");
    String requestString =
      "GET http://127.0.0.1:3000/logs HTTP/1.1\n"+
        "Authorization: Basic cGFzc3dvcmQ=\n";

    Request request = new Request(requestString).build();
    credential.isAuthorized(request);
  }
}