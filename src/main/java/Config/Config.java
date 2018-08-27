package Config;

import Logger.Logger;
import Request.Credential;
import Router.Handler.*;
import Routes.Route;
import Routes.Routes;

import java.io.File;
import java.io.IOException;

import static Validator.Validator.*;
import static utils.Method.*;

public class Config {
  public static final Credential credential = new Credential("one", "two");
  public static final Routes routes = setRoutes();
  public static final String rootPath = System.getProperty("user.dir");
  public static final File publicDirectory = setPublicDirectory();
  public static final Logger logger = setLogger();

  private static File setPublicDirectory() {
    File file = new File(rootPath + "/src/main/java/assets/public");
    if (!file.isDirectory()) {
      file = new File(rootPath + "/assets/public");
    }
    return file;
  }

  private static Logger setLogger() {
    Logger logger = new Logger();
    logger.createLogFile("logs.txt");
    return logger;
  }

  private static Routes setRoutes() {
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
    routes.add(new Route(GET, "/logs", new AUTHHandler()));
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
