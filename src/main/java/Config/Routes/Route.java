package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;
import Response.Response;

abstract public class Route {
	Method method;
	String path;
	public Handler handler;
	Response response;

	public Method getMethod() {
		return method;
	}
	public String getPath() {
		return path;
	}

}

