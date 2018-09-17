package application.controller;

import http_server_app.application.controllers.AUTHHandler;
import http_server_app.server.Logger.Logger;
import http_server_app.server.Request.Request;
import http_server_app.server.Response.Response;
import http_server_app.server.ServerConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AUTHHandlerTest {
  @Test
  public void testAuthHandlerBodyToBeEmpty() {
    String requestString =
      "GET http://127.0.0.1:3000/logs HTTP/1.1\r\n"+
        "Authorization: Basic cGFzc3dvcmQ=\r\n";
    ServerConfig.logger = new Logger();
    ServerConfig.logger.createLogFile("logs.txt");
    Request request = new Request(requestString).build();
    Response body = new AUTHHandler().get(request);
    assertEquals(401, body.status.code);
  }
}