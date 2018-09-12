package http_server_app.server.Logger;

import http_server_app.application.config.Config;
import http_server_app.server.Directory.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

  private static String getDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    return formatter.format(new Date());
  }

  public void log(String infoType, String message) {
    FileHandler logger = new FileHandler(Config.logger.logFile);
    logger.addContent(getDate() + " [" + infoType + "]: " + message + "\n");
  }
}
