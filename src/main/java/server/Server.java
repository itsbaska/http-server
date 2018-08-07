package Server;
import Controller.Controller;
import Request.Request;
import Response.Response;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
  Controller controller = new Controller();

  public void go(String port) throws IOException {
    System.out.println("Starting Server on PORT: " + port);
    ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));

    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("\nAccepted connection from testClient: " + clientSocket.getRemoteSocketAddress());

      handleRequest(clientSocket);

      clientSocket.close();
      System.out.println("\nClosing connection with testClient: " + clientSocket.getInetAddress());
    }
  }

  private void handleRequest(Socket clientSocket) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
      StringBuilder requestBuilder = new StringBuilder();
      while (in.ready() || requestBuilder.length() == 0) {
        requestBuilder.append((char) in.read());
      }
      PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      Request request = new Request.Builder().build(requestBuilder.toString());

      Response response = controller.handleRequest(request);
      out.write(response.text);

      out.flush();
      out.close();
      in.close();
    } catch (IOException ex) {
      System.out.println(ex);
      System.out.println("Read failed");
      System.exit(-1);
    }
  }
}
