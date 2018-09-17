package http_server_app.server.Routes;

import http_server_app.application.controllers.DirectoryHandler;
import http_server_app.application.controllers.StaticHandlers.StaticFileHandler;

import java.io.File;

import static http_server_app.application.config.Config.publicDirectory;

public interface RoutesSetter {
  void setRoutes(Routes routes);

  default void setStaticRoutes(Routes routes, File directory) {
    File[] files = directory.listFiles();
    for (File file : files) {
      String path = file.getPath().replace(publicDirectory.getPath(), "");
      if (file.isDirectory()) {
        setStaticRoutes(routes, file);
        routes.add(path, new DirectoryHandler(file));
      } else {
        routes.add(path, new StaticFileHandler(file));
      }
    }
  }
}
