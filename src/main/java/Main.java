import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Robot robot = null;
        Position p = null;
        String inputCommand = null;
        String[] inputContent = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/in/input1.txt"));
            String line = reader.readLine().toUpperCase();
            while (line != null){
                System.out.println(line);
                Integer inputIndex = line.indexOf(" ",0);
                if (inputIndex != -1){
                    inputCommand = line.substring(0, inputIndex);
                    if (inputCommand.equals("PLACE")){
                        inputContent = line.substring(inputIndex+1).split(",");
                        Direction direction = Direction.valueOf(inputContent[2]);
                        try {
                            Position position = new Position(Integer.parseInt(inputContent[0]),
                                    Integer.parseInt(inputContent[1]), direction);
                            robot = new Robot(position);
                            p = robot.getPosition();
                            System.out.println("initial position: " + p.getxPosition() + " " + p.getyPosition() + " " + p.getDirection());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    inputCommand = line;
                }

                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
