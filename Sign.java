import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sign {
    public void reserve(String request) throws IOException {
        String[] writeLine;
        writeLine = request.split("\\s");
        FileReader reader = new FileReader("Data/Reserved.txt");
        FileWriter writer = new FileWriter("Data/Reserved.txt", true);
        Scanner scanner = new Scanner(reader);
        String time = writeLine[0];
        writeLine[0] = "";
        String line = String.join(" ", writeLine);
        writer.write(line);
        writer.write("\n" + time + "\n");
        writer.flush();
        while(true) {
            // System.out.println(scanner.nextLine());
            if(scanner.hasNextLine())
                if (!scanner.nextLine().equals(line)) {
                    continue;

                } else {

                    System.out.println(time);
                    reader = new FileReader("Data/FreeTime.txt");
                    scanner = new Scanner(reader);
                    writer = new FileWriter("Data/Temp.txt");
                    while (scanner.hasNextLine()){
                        String tmp = scanner.nextLine();
                        String[] deleter;
                        ArrayList<String> res = new ArrayList<>();
                        if(tmp.startsWith("1") || tmp.startsWith("0")){
                            deleter = tmp.split("\\s");
                            for(int i = 0; i < deleter.length; i++){
                                if(!deleter[i].equals(time)) {
                                    res.add(deleter[i]);
                                }
                            }


                            tmp = String.join(" ", res);
                        }
                        writer.write(tmp + "\n");
                        writer.flush();
                    }
                    break;
                }

        }
        reader = new FileReader("Data/Temp.txt");
        scanner = new Scanner(reader);
        writer = new FileWriter("Data/FreeTime.txt");
        while (scanner.hasNextLine()){
            writer.write(scanner.nextLine() + "\n");
            writer.flush();
        }

    }
}
