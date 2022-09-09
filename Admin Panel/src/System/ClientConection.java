package System;

import java.io.IOException;
import java.net.Socket;

public class ClientConection {
    Socket socket;
    ClientConection(){
        try {
            socket=new Socket("127.0.0.1",1245);
            System.out.println("Connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Socket getServerSocket(){
        return socket;
    }
    void CloseConection(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not Closed");
        }
    }
}
