import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{

        ArrayList<Robot> robotList = new ArrayList<Robot>();
        Command command = new Command();
        Position position = null;
        String inputCommand = null;
        String[] inputContent = null;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/in/input1.txt"));
            String line = reader.readLine().toUpperCase();
            while (line != null){
//                System.out.println(line);
//                Find the Place command
                Integer inputIndex = line.indexOf(" ",0);
                if (inputIndex != -1){
//                    Find the 'PLACE' command
                    inputCommand = line.substring(0, inputIndex);
                    if (inputCommand.toUpperCase().equals("PLACE")){
                        Robot robot = null;
//                       Get the command detail and store to an array
                        inputContent = line.substring(inputIndex+1).split(",");
//                        Convert direction from string to enum type
                        Direction direction = Direction.valueOf(inputContent[2].toUpperCase());
                        robot = command.place(Integer.parseInt(inputContent[0]),
                                        Integer.parseInt(inputContent[1]),
                                        direction);
                        robotList.add(robot);
//                        System.out.println("initial position: " + position.getxPosition() + " " +
//                                                position.getyPosition() + " " + position.getDirection());

                    }
                }else{
                    inputCommand = line;
                    if(robotList != null){
                        if (inputCommand.toUpperCase().equals("MOVE")){
                            for(int robotNum = 1; robotNum <= robotList.size(); robotNum++){
                                command.move(robotList.get(robotNum-1).getPosition());
                            }
                        }else if (inputCommand.toUpperCase().equals("LEFT")){
                            for(int robotNum = 1; robotNum <= robotList.size(); robotNum++){
                                command.leftCommand(robotList.get(robotNum-1).getPosition());
                            }
                        }else if(inputCommand.toUpperCase().equals("RIGHT")){
                            for(int robotNum = 1; robotNum <= robotList.size(); robotNum++){
                                command.rightCommand(robotList.get(robotNum-1).getPosition());
                            }
                        }else if(inputCommand.toUpperCase().equals("REPORT")){
                            for(int robotNum = 1; robotNum <= robotList.size(); robotNum++){
                                String output = command.reportCommand(robotList.get(robotNum-1));
                                if (output != null){
                                    System.out.println("Robot "+ robotNum + ": " + output);
                                }else{
                                    System.out.println("Robot" + robotNum + "cannot excute commands because of ");
                                }

                            }
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
