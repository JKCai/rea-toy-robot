import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader reader;
        Robot robot = null;
        try {
            reader = new BufferedReader(new FileReader("src/in/input1.txt"));
            String line = reader.readLine().toUpperCase();
            while (line != null){
                Command c = CommandFactory.getCommand(line);
                robot = c.doCommand(robot);
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
