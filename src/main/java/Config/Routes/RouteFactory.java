package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

import static Config.Method.*;

public class RouteFactory {

	public Route createRoute(Method method, String path, Handler handler) {
		Route route = null;
		if (method == GET) {
			route = new GETRoute(method, path, handler);
		} else if (method == POST) {
			route = new POSTRoute(method, path, handler);
		}
		return route;
	}
}