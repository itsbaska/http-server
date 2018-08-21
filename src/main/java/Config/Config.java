package Config;

import Config.Routes.Route;
import Config.Routes.Routes;
import Controller.Handler.*;

import java.io.IOException;

import static Config.Method.*;
import static Validator.Validator.*;

public class Config {
  public static Routes setRoutes() {
    Routes routes = new Routes();
    routes.add(new Route(GET, "/", new GETHandler()));
    routes.add(new Route(GET, "/echo", new GETEchoHandler()));
    routes.add(new Route(POST, "/echo", new POSTEchoHandler()));
    routes.add(new Route(PUT, "/form", new PUTFormHandler()));
    routes.add(new Route(POST, "/form", new POSTFormHandler()));
    routes.add(new Route(OPTIONS, "/method_options", new OPTIONSHandler()));
    routes.add(new Route(OPTIONS, "/method_options2", new OPTIONS2Handler()));
    routes.add(new Route(GET, "/not-found", new NotFoundHandler()));
    routes.add(new Route(HEAD, "/", new HEAD200Handler()));
    routes.add(new Route(HEAD, "/foobar", new HEAD404Handler()));
    routes.add(new Route(GET, "/redirect", new RedirectHandler()));
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
