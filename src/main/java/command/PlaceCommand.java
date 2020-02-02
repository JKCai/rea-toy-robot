import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaceCommand extends Command {

    private String [] commandContent;
    Position placePosition;

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    public PlaceCommand(String [] commandString){
        log.debug("receive place command content");
        this.commandContent = commandString;
    }

    @Override
    public Robot doCommand(Robot robot) throws Exception {
        String [] commandString = this.commandContent;
        log.debug(commandContent.toString());
        if (commandString.length == 3 && commandString[0]!=null &&
                commandString[1]!=null && commandString[2]!=null){
            placePosition = new Position(Integer.parseInt(commandString[0]),
                    Integer.parseInt(commandString[1]),
                    Direction.valueOf(commandString[2].toUpperCase()));
        }else {
            throw new InvalidCommandException("Invalid Command - missing argument");
        }

        if (placePosition == null){
            throw new InvalidPositionException("Exceed bourndary");
        }else{
            robot = new Robot(placePosition);
        }
        log.debug("robot is placed at: " + robot.getPositionString());
        return robot;
    }
}
