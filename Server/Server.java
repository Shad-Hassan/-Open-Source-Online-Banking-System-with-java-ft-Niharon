package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(1245);
        System.out.println("Server Started..........");
        Statement statement=DatabaseConnection.Connection();
        while (true){
            try {
                Socket socket=serverSocket.accept();
                System.out.println("Client Connected");
                new ServerThread(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
