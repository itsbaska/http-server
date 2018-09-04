package Config;

import Directory.Directory;
import Logger.Logger;
import Request.Credential;
import Router.Handler.*;
import Router.Handler.StaticHandlers.*;
import Routes.Routes;
import Storage.Storage;

import java.io.File;
import java.io.IOException;

import static Validator.Validator.*;
import static utils.Method.*;

public class Config {
  public static final Credential credential = new Credential("one", "two");
  public static final String rootPath = System.getProperty("user.dir");
  public static final File publicDirectory = setPublicDirectory();
  public static final Routes routes = setRoutes();
  public static final Logger logger = setLogger();
  public static final Storage storage = new Storage();


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
    routes.add(GET, "/", new GETHandler());
    routes.add(GET, "/echo", new GETEchoHandler());
    routes.add(POST, "/echo", new POSTEchoHandler());
    routes.add(PUT, "/form", new PUTFormHandler());
    routes.add(POST, "/form", new POSTFormHandler());
    routes.add(OPTIONS, "/method_options", new OPTIONSHandler());
    routes.add(OPTIONS, "/method_options2", new OPTIONS2Handler());
    routes.add(GET, "/not-found", new NotFoundHandler());
    routes.add(HEAD, "/", new HEAD200Handler());
    routes.add(GET, "/redirect", new RedirectHandler());
    routes.add(GET, "/logs", new AUTHHandler());
    routes.add(GET, "/parameters", new ParameterHandler());
    routes.add(GET, "/formData", new GETFormDataHandler());
    routes.add(POST, "/formData", new POSTFormDataHandler());
    routes.add(PUT, "/formData", new PUTFormDataHandler());
    routes.add(DELETE, "/formData", new DELETEFormDataHandler());
    setStaticRoutes(routes);
    return routes;
  }

  private static void setStaticRoutes(Routes routes) {
    Directory directory = new Directory(publicDirectory);
    for (String fileName : directory.getFileNames()) {
      routes.add(GET, "/" + fileName, new GETFileHandler(fileName));
    }
    routes.add(PATCH, "/patch-content.txt", new PATCHFileHandler("patch-content.txt"));
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
