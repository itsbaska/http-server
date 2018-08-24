package Directory;

import java.util.ArrayList;

public class DirectoryFormatter {
  public static String link(String folderName) {
    return "<a href=\"/" + folderName + "\">" + folderName + "</a>";
  }

  public static String list(ArrayList<String> files) {
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

  public static String createHtml(String body) {
    return "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <title>Title</title>\n" +
      "</head>\n" +
      "<body>\n" +
      body +
      "</body>\n" +
      "</html>";
  }
}
