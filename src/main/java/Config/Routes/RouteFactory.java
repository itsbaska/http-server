package Config.Routes;

public class RouteFactory {
	SimpleRouteFactory factory;
 
	public RouteFactory(SimpleRouteFactory factory) {
		this.factory = factory;
	}
 
	public Route createRoute(Method method, String path) {
		Route route;
 
		route = factory.createRoute(method, path);

		return route;
	}

}
