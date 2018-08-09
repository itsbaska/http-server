package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

public class RouteFactory {
	SimpleRouteFactory factory;
 
	public RouteFactory(SimpleRouteFactory factory) {
		this.factory = factory;
	}
 
	public Route createRoute(Method method, String path, Handler handler) {
		Route route;
 
		route = factory.createRoute(method, path, handler);

		return route;
	}

}
