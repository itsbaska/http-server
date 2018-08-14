package Config;

import Config.Routes.Route;
import Config.Routes.RouteFactory;
import Controller.Handler.GetEchoHandle;
import Controller.Handler.GetHandle;
import Controller.Handler.Handler;
import Controller.Handler.PostEchoHandle;

import java.io.IOException;

import java.util.ArrayList;

import static Config.Method.GET;
import static Config.Method.POST;

import static Validator.Validator.portIsNotAvailable;
import static Validator.Validator.validArgsLength;
import static Validator.Validator.validFlag;

public class Config {
  public static ArrayList<Route> routes = new ArrayList<>();
  public static ArrayList<Handler> handlers = new ArrayList<>();

  public static void createRoutes() {
    RouteFactory factory = new RouteFactory();
    routes.add(factory.createRoute(GET, "/", new GetHandle()));
    routes.add(factory.createRoute(GET, "/echo", new GetEchoHandle()));
    routes.add(factory.createRoute(POST, "/echo", new PostEchoHandle()));
  }

  public static ArrayList<Handler> allHandlers() {
    handlers.add(new GetHandle());
    handlers.add(new GetEchoHandle());
    handlers.add(new PostEchoHandle());
    return handlers;
  }

  public static ArrayList<Route> allRoutes() {
    return routes;
  }

  public static String setPort(String[] args) throws IOException {
    String port = null;
    if (validArgsLength(args) && validFlag(args)) {
      String chosenPort = args[1];
      if (portIsNotAvailable(chosenPort)) {
        System.err.println("PORT: " + chosenPort + " is already in use.");
        System.exit(1);
      } else {
        System.out.println("PORT: " + chosenPort);
        System.out.println("Success!");
        port = chosenPort;
      }
    }
    return port;
  }
}
