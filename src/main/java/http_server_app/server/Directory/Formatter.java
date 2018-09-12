package http_server_app.server.Directory;

import http_server_app.application.config.Config;

import java.io.File;
import java.util.ArrayList;

public class Formatter {
  public static String htmlList(ArrayList<String> array) {
    StringBuilder list = new StringBuilder();
    list.append("<ul>\n");
    for (String element : array) {
      list
        .append("<li>")
        .append(element)
        .append("</li>\n");
    }
    list.append("</ul>\n");

    return list.toString();
  }

  public static String getFileListWithLinks(ArrayList<File> files) {
    ArrayList<String> fileLinkList = new ArrayList<>();
    for (File file : files) {
        fileLinkList.add("<a href=\"" + file.getPath().replace(Config.publicDirectory.getPath(), "") + "\">" + file.getName() + "</a>");
    }
    return htmlList(fileLinkList);
  }
}
