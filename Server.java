import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try {ServerSocket server = new ServerSocket(1712);while (true)
            try {
                Socket socket = server.accept();
                ThreadDealer td = new ThreadDealer();
                td.threadStarter(socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
