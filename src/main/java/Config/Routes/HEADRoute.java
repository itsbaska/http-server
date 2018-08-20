package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

public class HEADRoute extends Route {
	public HEADRoute(Method method, String path, Handler handler) {
		this.method = method;
		this.path = path;
		this.handler = handler;
	}
}
