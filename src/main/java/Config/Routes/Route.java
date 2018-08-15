package Config.Routes;

import Config.Method;
import Controller.Handler.Handler;

abstract public class Route {
	Method method;
	String path;
	public Handler handler;

	public Method getMethod() {
		return method;
	}
	public String getPath() {
		return path;
	}
	public Handler getHandler() { return  handler; }

}

