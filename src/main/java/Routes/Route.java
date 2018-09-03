package Routes;

import utils.Method;
import Router.Handler.Handler;

import java.util.HashMap;

public class Route extends Routes {
	public final String path;
	public HashMap<Method, Handler> handlers = new HashMap<>();

	public Route(String path) {
		this.path = path;
	}

	public void setHandler(Method method, Handler handler) {
    this.handlers.put(method, handler);
	}

	public Handler getHandler(Method method) {
	  return handlers.get(method);
  }

}

