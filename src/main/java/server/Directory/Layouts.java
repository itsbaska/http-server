package server.Directory;

public class Layouts {
  public static String html(String body) {
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
