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
    public AbstractRobot doCommand(AbstractRobot robot) throws Exception {
        String [] commandString = this.commandContent;
        log.debug(commandContent.toString());
        if (commandString.length == 3){
            placePosition = new Position(Integer.parseInt(commandString[0].trim()),
                    Integer.parseInt(commandString[1].trim()),
                    Direction.valueOf(commandString[2].trim().toUpperCase()));
        }else {
            throw new InvalidCommandException("Invalid Command - missing argument");
        }

        robot = RobotFactory.getRobot(placePosition);
        log.debug("robot is placed at: " + robot.getPositionString());
        return robot;
    }
}
