package http_server_app.server.Logger;

import http_server_app.application.config.Config;

import java.io.File;
import java.io.IOException;

public class Logger {
  public File logFile;

  public void createLogFile(String logFileName) {
    File logFile = new File(Config.rootPath + "/" + logFileName);
    try {
      if (logFile.createNewFile()) {
        this.logFile = logFile;
        System.out.println("logs.txt is created!");
      } else {
        this.logFile = logFile;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
