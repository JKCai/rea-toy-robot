import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftCommand extends Command {

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    @Override
    public AbstractRobot doCommand(AbstractRobot robot) throws Exception{
        if(robot != null){
            Position p = robot.getPosition();
            switch(p.getDirection()){
                case NORTH:
                    robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.WEST));
                    break;
                case SOUTH:
                    robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.EAST));
                    break;
                case EAST:
                    robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.NORTH));
                    break;
                case WEST:
                    robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.SOUTH));
                    break;
            }
            log.debug("Robot success to rotate left to direction" + robot.getPosition().getDirection());

        }

        return robot;
    }
}
