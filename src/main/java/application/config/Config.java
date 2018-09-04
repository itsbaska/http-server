package application.config;

import application.controller.Handler.*;
import application.controller.Handler.StaticHandlers.StaticFileHandler;
import server.Directory.Directory;
import server.Logger.Logger;
import server.Request.Credential;
import server.Routes.Routes;
import storage.Storage;

import java.io.File;
import java.io.IOException;

import static server.Validator.Validator.*;

public class Config {
  public static final Credential credential = new Credential("one", "two");
  public static final String rootPath = System.getProperty("user.dir");
  public static final File publicDirectory = setPublicDirectory();
  public static final Routes routes = setRoutes();
  public static final Logger logger = setLogger();
  public static final Storage storage = new Storage();


  private static File setPublicDirectory() {
    File file = new File(rootPath + "/src/main/java/application/assets/public");
    if (!file.isDirectory()) {
      file = new File(rootPath + "/application/public");
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
    routes.add("/", new RootHandler());
    routes.add("/echo", new EchoHandler());
    routes.add("/form", new FormHandler());
    routes.add("/method_options", new OPTIONSHandler());
    routes.add("/method_options2", new OPTIONS2Handler());
    routes.add("/not-found", new NotFoundHandler());
    routes.add("/redirect", new RedirectHandler());
    routes.add("/logs", new AUTHHandler());
    routes.add("/parameters", new ParameterHandler());
    routes.add("/formData", new FormDataHandler());
    setStaticRoutes(routes);
    return routes;
  }

  private static void setStaticRoutes(Routes routes) {
    Directory directory = new Directory(publicDirectory);
    for (String fileName : directory.getFileNames()) {
      routes.add("/" + fileName, new StaticFileHandler(fileName));
    }
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
