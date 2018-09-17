package http_server_app.server;

import http_server_app.application.AppRoutes;
import http_server_app.server.Logger.Logger;
import http_server_app.server.Routes.Controller;
import http_server_app.server.Routes.Routes;
import http_server_app.storage.Storage;

import static http_server_app.application.config.Config.publicDirectory;

public class ServerConfig {
  public static Logger logger;
  public static Storage storage = new Storage();
  public static int DEFAULT_PORT = 3000;

  public static void setup(Server server, String[] args) {
    logger = new Logger();
    System.out.println(logger);
    logger.createLogFile("logs.txt");
    AppRoutes appRoutes = new AppRoutes();
    server.routes = new Routes();
    appRoutes.setRoutes(server.routes);
    appRoutes.setStaticRoutes(server.routes, publicDirectory);

    server.setPort(args);
    server.setController(new Controller(server.routes));
  }
}
