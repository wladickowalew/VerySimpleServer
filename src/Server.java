import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static private BufferedReader in;
    static private BufferedWriter out;
    static private Socket client;
    static private int count;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        count = 0;
        System.out.println("Server on\nReady for connection...");
        while (true) {
            waiting(server);
//            System.out.println("user " + count +" connected");
            String name = in.readLine();
//            System.out.println("Hes name is " + name);
            sendText("Hello, " + name + "!");
            sendText("You are " + count +" user");
            closeConnection();
        }
    }

    static private void waiting(ServerSocket server) throws IOException {
        client = server.accept();
        count++;
        System.out.println("connection Success");
        in  = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()));
        out = new BufferedWriter(
                new OutputStreamWriter(
                        client.getOutputStream()));
    }

    static private void closeConnection() throws IOException {
        out.close();
        in.close();
        client.close();
        System.out.println("connection off\n\n");
    }

    static private void sendText(String text) throws IOException {
        System.out.println("Send: " + text);
        out.write(text + "\n");
        out.flush();
    }
}
