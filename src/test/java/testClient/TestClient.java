package testClient;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import Request.GetRequest;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestClient {
  int PORT = 3000;
  private Socket socket;
  private PrintWriter out;
  private BufferedReader in;

  public TestClient() throws IOException {
    socket = new Socket("127.0.0.1", PORT);
    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
  }

  public void sendRequest(String request) {
    out.write(request);
    out.flush();
  }

  public String getResponse() throws IOException {
    StringBuilder responseBuilder = new StringBuilder();

    while (in.ready() || responseBuilder.length() == 0) {
      responseBuilder.append((char) in.read());
    }
    System.out.print(responseBuilder.toString());
    return responseBuilder.toString();
  }

  public void closeSocket() throws IOException {
    in.close();
    out.close();
    socket.close();
  }
}
