import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception{

        Robot robot = null;
        Command command = new Command();
        Position position = null;
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
                if (inputIndex != -1){
//                    Find the 'PLACE' command
                    inputCommand = line.substring(0, inputIndex);
                    if (inputCommand.toUpperCase().equals("PLACE")){
//                       Get the command detail and store to an array
                        inputContent = line.substring(inputIndex+1).split(",");
//                        Convert direction from string to enum type
                        Direction direction = Direction.valueOf(inputContent[2].toUpperCase());
                        robot = command.place(Integer.parseInt(inputContent[0]),
                                        Integer.parseInt(inputContent[1]),
                                        direction);
                        position = robot.getPosition();
                        System.out.println("initial position: " + position.getxPosition() + " " +
                                                position.getyPosition() + " " + position.getDirection());

                    }
                }else{
                    inputCommand = line;
                    if(robot != null){
                        if (inputCommand.toUpperCase().equals("MOVE")){
                            position = robot.move();
                            robot.setPosition(position);
                            System.out.println("moved position:   " +
                                                robot.getPosition().getxPosition() + " " +
                                                robot.getPosition().getyPosition() + " " +
                                                robot.getPosition().getDirection());
                        }else if (inputCommand.toUpperCase().equals("LEFT")){
                            position = command.leftCommand(robot.getPosition());
                            robot.setPosition(position);
                            System.out.println("turnLeft position:    " +
                                                robot.getPosition().getxPosition() + " " +
                                                robot.getPosition().getyPosition() + " " +
                                                robot.getPosition().getDirection());
                        }else if(inputCommand.toUpperCase().equals("RIGHT")){
                            position = command.rightCommand(robot.getPosition());
                            robot.setPosition(position);
                            System.out.println("turnRight position:    " +
                                                robot.getPosition().getxPosition() + " " +
                                                robot.getPosition().getyPosition() + " " +
                                                robot.getPosition().getDirection());
                        }else{
                            new InvalidCommandException("error: invalid command");
                        }
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
