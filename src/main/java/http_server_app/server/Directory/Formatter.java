package http_server_app.server.Directory;

import java.util.ArrayList;

public class Formatter {
  public static String link(String name) {
    return "<a href=\"/" + name + "\">" + name + "</a>";
  }

  public static String list(ArrayList<String> files) {
    StringBuilder list = new StringBuilder();
    list.append("<ul>\n");
    for (String file : files) {
      list
        .append("<li>")
        .append(file)
        .append("</li>\n");
    }
    list.append("</ul>\n");

    return list.toString();
  }

  public static String unorderedList(ArrayList<String> files) {
    StringBuilder list = new StringBuilder();
    list.append("<ul>\n");
    for (String file : files) {
      list
        .append("<li>")
        .append(link(file))
        .append("</li>\n");
    }
    list.append("</ul>\n");

    return list.toString();
  }
}
