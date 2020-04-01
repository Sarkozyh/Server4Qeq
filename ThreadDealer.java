
import java.io.*;
import java.net.Socket;

public class ThreadDealer {
    public void threadStarter(Socket socket){
        try{
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));


            Thread myThready = new Thread(new Runnable()
            {
                public void run() //Этот метод будет выполняться в побочном потоке
                {

                    //System.out.println("over here");
                    try {
                        //System.out.println("here");
                        String request = reader.readLine();
                        System.out.println(request);
                        String response = null;
                        if(request.startsWith("1") || request.startsWith("0")){
                            Sign sign = new Sign();
                            sign.reserve(request);
                            response = "qeq";
                        }else {
                            GetFreeTime get = new GetFreeTime(request);
                            response = get.timeGeter();
                        }
                        writer.write(response);
                        writer.newLine();
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            myThready.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
