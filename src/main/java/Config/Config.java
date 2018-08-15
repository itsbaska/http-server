package Config;

import Config.Routes.RouteFactory;
import Config.Routes.Routes;
import Controller.Handler.GETEchoHandler;
import Controller.Handler.GETHandler;
import Controller.Handler.POSTEchoHandler;
import Controller.Handler.POSTFormHandler;

import java.io.IOException;

import static Config.Method.GET;
import static Config.Method.POST;
import static Validator.Validator.*;

public class Config {
  public static Routes setRoutes() {
    Routes routes = new Routes();
    RouteFactory factory = new RouteFactory();
    routes.add(factory.createRoute(GET, "/", new GETHandler()));
    routes.add(factory.createRoute(GET, "/echo", new GETEchoHandler()));
    routes.add(factory.createRoute(POST, "/echo", new POSTEchoHandler()));
    routes.add(factory.createRoute(POST, "/form", new POSTFormHandler()));

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
