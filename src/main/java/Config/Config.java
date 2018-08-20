package Config;

import Config.Routes.RouteFactory;
import Config.Routes.Routes;
import Controller.Handler.*;

import java.io.IOException;

import static Config.Method.*;
import static Validator.Validator.*;

public class Config {
  public static Routes setRoutes() {
    Routes routes = new Routes();
    RouteFactory factory = new RouteFactory();
    routes.add(factory.createRoute(GET, "/", new GETHandler()));
    routes.add(factory.createRoute(GET, "/echo", new GETEchoHandler()));
    routes.add(factory.createRoute(POST, "/echo", new POSTEchoHandler()));
    routes.add(factory.createRoute(PUT, "/form", new PUTFormHandler()));
    routes.add(factory.createRoute(POST, "/form", new POSTFormHandler()));
    routes.add(factory.createRoute(OPTIONS, "/method_options", new OPTIONSHandler()));
    routes.add(factory.createRoute(OPTIONS, "/method_options2", new OPTIONS2Handler()));
    routes.add(factory.createRoute(HEAD, "/foobar", new HEAD404Handler()));


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
