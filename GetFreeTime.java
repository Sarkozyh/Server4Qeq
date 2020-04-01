import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GetFreeTime {
    FileReader reader;
    String needed;
    //String id;

    GetFreeTime(String needed){
        this.needed = needed;

    }

    public String timeGeter() throws Exception{
        reader = new FileReader("Data/FreeTime.txt");
        Scanner scan = new Scanner(reader);
        String time = null;
        System.out.println(needed);
        // System.out.println(scan.nextLine());
        while(true) {
            if (scan.nextLine().equals(needed)) {
                time = scan.nextLine();
                System.out.println(time);
                break;
            } else {
                scan.nextLine();
            }
        }

            /*while(true){
                if(scan.nextLine() != needed) {
                    scan.nextLine();
                    time = scan.nextLine();

                }
                else if(scan.nextLine() == needed){
                    time = scan.nextLine();

                    break;
                }else{
                    time = scan.nextLine();
                    System.out.println("qeq");
                    break;
                }
            }*/
        reader.close();
        scan.close();
        return time;
    }
}
