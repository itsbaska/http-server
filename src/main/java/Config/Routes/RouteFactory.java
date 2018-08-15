package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

public class RouteFactory {

	public Route createRoute(Method method, String path, Handler handler) {
		Route route = null;
    switch (method) {
      case GET:
			  return new GETRoute(method, path, handler);
      case POST:
  			return new POSTRoute(method, path, handler);
      case PUT:
	  		return new PUTRoute(method, path, handler);
      default:
        throw new Error();
    }
	}
}