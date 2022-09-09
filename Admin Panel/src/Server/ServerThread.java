package Server;

import java.io.IOException;
import java.net.Socket;

class ServerThread implements Runnable {

    Socket socket;
    Thread t;
    NetworkConnection networkConnection;

    ServerThread(Socket socket) {
        this.socket = socket;
        t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        try {
            networkConnection = new NetworkConnection(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cmd=(String) networkConnection.read();
        String[] str=cmd.split("@");
        for (String s:str){
            System.out.println(s);
        }
        if(str[0].equals("Transfer")){
            ServerTask.TransferTask(str[1],str[2],str[3],DatabaseConnection.Connection(),networkConnection);
        }else if(str[0].equals("Add")){
            ServerTask.Add(str[1],str[6],DatabaseConnection.Connection(),networkConnection);
        }else if (str[0].equals("Deposit")){
            ServerTask.Add(str[1],str[2],DatabaseConnection.Connection(),networkConnection);
        }else if(str[0].equals("Withdraw")){
            ServerTask.Withdraw(str[1],str[2],DatabaseConnection.Connection(),networkConnection);
        }else if(str[0].equals("Charge")){
            ServerTask.WithdrawAll(str[1],DatabaseConnection.Connection(),networkConnection);
        }else {
            //Message here
        }

    }
}