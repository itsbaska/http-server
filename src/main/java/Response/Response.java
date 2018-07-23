package Response;

import java.io.*;

public class Response {
  public String res200(String content) {
    String headers = "HTTP/1.1 200 OK\r\n" +
      "Content-Length: " + (content + "\r\n\r\n").length() + "\r\n" +
      "Content-Type: text/html\r\n\r\n" +
      content +
      "\r\n\r\n";
    return headers;
  }
//
//  public String getHtmlContent(String filename) {
//    String response = "";
//    String line;
//
//    try {
//      File helloWorld = new File(filename);
//      BufferedReader reader = new BufferedReader(new FileReader(helloWorld));
//      try {
//        while ((line = reader.readLine()) != null) {
//          response += line;
//        }
//      } catch (IOException ex) {
//        ex.printStackTrace();
//      }
//    } catch (FileNotFoundException exception) {
//      System.out.println(exception);
//    }
//    return response;
//  }

}
