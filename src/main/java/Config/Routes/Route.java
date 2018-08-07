package Config.Routes;

abstract public class Route {
	Method method;
	String path;

	public Method getMethod() {
		return method;
	}
	public String getPath() {
		return path;
	}
}

