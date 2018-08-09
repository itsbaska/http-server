package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

public class GetRoute extends Route {
	public GetRoute(Method method, String path, Handler handler) {
		this.method = method;
		this.path = path;
		this.handler = handler;
	}
}
