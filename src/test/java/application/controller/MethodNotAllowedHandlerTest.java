package application.controller;

import http_server_app.application.controllers.MethodNotAllowedHandler;
import http_server_app.server.Response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MethodNotAllowedHandlerTest {
  @Test
  public void testMethodNotAllowedStatusCodeToBe405() {
    Response response = new MethodNotAllowedHandler().getResponse();
    assertEquals(405, response.status.code);
  }
}