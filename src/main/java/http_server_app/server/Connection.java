package http_server_app.server;

import http_server_app.application.config.Config;
import http_server_app.application.controller.Controller;
import http_server_app.application.controller.Handler.MethodNotAllowedHandler;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.utils.InvalidRequestException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Connection {
  private Socket socket;
  private Controller controller = new Controller();
  private Request request;
  private BufferedReader in;
  private DataOutputStream out;
  private boolean invalidRequest;

  public Connection(Socket socket) {
    this.socket = socket;
  }

  private void readRequest() throws IOException {
    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
    StringBuilder requestBuilder = new StringBuilder();
    while (in.ready() || requestBuilder.length() == 0) {
      requestBuilder.append((char) in.read());
    }
    try {
      this.request = new Request(requestBuilder.toString()).build();
    } catch (InvalidRequestException e) {
      Config.logger.log("ERROR", e.getMessage());

      invalidRequest = true;
    }
  }

  private void writeResponse() throws IOException {
    Response response;
    if (invalidRequest) {
      response = new MethodNotAllowedHandler().getResponse();
    } else {
      response = controller.handleRequest(request);
    }
    out = new DataOutputStream(socket.getOutputStream());
    out.write(response.responseBytes());
    out.flush();
  }

  public void run() {
    try {
      readRequest();
      writeResponse();
      out.close();
      in.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println("Read failed");
      Config.logger.log("ERROR", ex.getMessage());
    }
  }
}
