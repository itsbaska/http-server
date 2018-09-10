package http_server_app.server.utils;

public class MimeType {
  public static String getType(String extension) {
    switch (extension) {
      case "txt":
        return "text/plain";
      case "html":
        return "text/html";
      case "gif":
        return "image/gif";
      case "png":
        return "image/png";
      case "jpeg":
        return "image/jpeg";
      default:
        return "text/plain";
    }
  }
}
