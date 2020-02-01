import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception{

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
//                Find the Place command
                Integer inputIndex = line.indexOf(" ",0);
//
                if (inputIndex != -1){
//                    Find the 'PLACE' command
                    inputCommand = line.substring(0, inputIndex);
                    if (inputCommand.equals("PLACE")){
//                       Get the command detail and store to an array
                        inputContent = line.substring(inputIndex+1).split(",");
//                        Convert direction from string to enum type
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
                    if(robot != null){
                        if (inputCommand.equals("MOVE")){
                            p = robot.move();
                            robot.setPosition(p);
                            System.out.println("moved position:   " + robot.getPosition().getxPosition() + " " + robot.getPosition().getyPosition() + " " + robot.getPosition().getDirection());
                        }
                        System.out.println("im here");
                    }
                }

                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
