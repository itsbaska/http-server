package http_server_app.application.config;

import http_server_app.server.Request.Credential;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
  public static final Credential credential = new Credential("one", "two");
  public static final Path rootPath = Paths.get(".","src", "main", "java", "http_server_app");
  public static final File publicDirectory = rootPath.resolve(Paths.get("application", "assets", "public")).toFile();
}
