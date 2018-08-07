package Config.Routes;

import static Config.Routes.Method.*;

public class SimpleRouteFactory {

	public Route createRoute(Method method, String path) {
		Route route = null;
		if (method == GET) {
			route = new GetRoute(method, path);
		} else if (method == POST) {
			route = new PostRoute(method, path);
		}
		return route;
	}
}