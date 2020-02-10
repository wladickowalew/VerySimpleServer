import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 8000);
        System.out.println("Connection is OK");
        BufferedReader in  = new BufferedReader(
                                new InputStreamReader(
                                        client.getInputStream()));
        BufferedWriter out = new BufferedWriter(
                                new OutputStreamWriter(
                                    client.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        out.write(name+"\n");
        out.flush();
        String response = in.readLine();
        System.out.println(response);
        response = in.readLine();
        System.out.println(response);
        in.close();
        sc.close();
        client.close();
    }
}
