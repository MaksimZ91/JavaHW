import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Repository {

    public static void write(String data){
        FileWriter writer = null;
        try {
            writer = new FileWriter("toys.txt", true);
            writer.append(data);
            writer.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void read(){
        try {
            FileReader reader = new FileReader("toys.txt");
            Scanner scan = new Scanner(reader);
            int i = 1;
            while (scan.hasNextLine()){
                System.out.println(i + " : " + scan.nextLine());
                i++;
            }
            reader.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }



}
