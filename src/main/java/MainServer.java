import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {
        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("New connection accepted. Port: " + clientSocket.getPort());
                    final String name = in.readLine();
                    out.println(name + ", your port is " + clientSocket.getPort());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}