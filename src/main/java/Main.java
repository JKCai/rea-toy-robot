import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader reader;
        AbstractRobot robot = null;
        try {
            Scanner inputFileNumber = new Scanner(System.in);
            System.out.println("\nEnter 1 or 2 or 3 to choose input file:");
            System.out.println("(NOTE: If you choose any number other than 1 to 3, the default value would be 3)");
            String fileNum = inputFileNumber.nextLine();
            switch (fileNum){
                case "1":
                    reader = new BufferedReader(new FileReader("src/in/input1.txt"));
                    break;
                case "2":
                    reader = new BufferedReader(new FileReader("src/in/input2.txt"));
                    break;
                case "3":
                    reader = new BufferedReader(new FileReader("src/in/input3.txt"));
                    break;
                default:
                    reader = new BufferedReader(new FileReader("src/in/input3.txt"));
            }

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
