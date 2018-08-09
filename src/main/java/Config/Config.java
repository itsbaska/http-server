package Config;

import Config.Routes.Route;
import Config.Routes.RouteFactory;
import Config.Routes.SimpleRouteFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import static Config.Routes.Method.GET;
import static Config.Routes.Method.POST;
import static Validator.Validator.validArgsLength;
import static Validator.Validator.validFlag;

public class Config {
  public static ArrayList<Route> routes = new ArrayList<>();
  public static void createRoutes() {
    SimpleRouteFactory factory = new SimpleRouteFactory();
    RouteFactory routeFactory = new RouteFactory(factory);
    routes.add(routeFactory.createRoute(GET, "/"));
    routes.add(routeFactory.createRoute(GET, "/echo"));
    routes.add(routeFactory.createRoute(POST, "/echo"));
  }

  public static ArrayList<Route> allRoutes() {
    return routes;
  }

  public static String setPort(String[] args) throws IOException {
    String port = null;
    if (validArgsLength(args) && validFlag(args)) {
      String chosenPort = args[1];
      if (portIsAvailable(chosenPort)) {
        System.err.println("PORT: " + chosenPort + " is already in use.");
        port = null;
      } else {
        System.out.println("PORT: " + chosenPort);
        System.out.println("Success!");
        port = chosenPort;
      }
    }
    return port;
  }

  public static boolean portIsAvailable(String port) throws IOException {
    try {
      (new Socket("127.0.0.1", Integer.parseInt(port))).close();
      return true;
    } catch (SocketException ignored) {
      return false;
    }
  }
}
