package http_server_app.server.Routes;

import http_server_app.application.controller.Handler.Handler;

public class Route extends Routes {
	public final String path;
  public Handler handler;

	public Route(String path, Handler handler) {
		this.path = path;
		this.handler = handler;
	}
}

