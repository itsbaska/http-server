package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

public class Route extends Routes {
	public final Method method;
	public final String path;
	public final Handler handler;

	public Route(Method method, String path, Handler handler) {
		this.method = method;
		this.path = path;
		this.handler = handler;
	}
}

