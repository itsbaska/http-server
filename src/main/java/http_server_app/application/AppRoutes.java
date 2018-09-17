package http_server_app.application;

import http_server_app.application.controllers.*;
import http_server_app.server.Routes.Routes;
import http_server_app.server.Routes.RoutesSetter;

import static http_server_app.application.config.Config.publicDirectory;

public class AppRoutes implements RoutesSetter {
  public void setRoutes(Routes routes) {
    routes.add("/", new DirectoryHandler(publicDirectory));
    routes.add("/echo", new EchoHandler());
    routes.add("/form", new FormHandler());
    routes.add("/method_options", new OPTIONSHandler());
    routes.add("/method_options2", new OPTIONS2Handler());
    routes.add("/not-found", new NotFoundHandler());
    routes.add("/redirect", new RedirectHandler());
    routes.add("/logs", new AUTHHandler());
    routes.add("/parameters", new ParameterHandler());
    routes.add("/formData", new FormDataHandler());
    routes.add("/tea", new TeaHandler());
    routes.add("/coffee", new CoffeeHandler());
  }
}
