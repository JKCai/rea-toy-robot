import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RightCommand extends Command {

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    @Override
    public Robot doCommand(Robot robot) throws Exception {
        if(robot != null){
            Position p = robot.getPosition();
            if(p.getDirection() == null || !p.checkValidDirection(p.getDirection())){
                log.debug("Invalid direction - cannot execute right command");
            }else {
                switch (p.getDirection()) {
                    case NORTH:
                        robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.EAST));
                        break;
                    case SOUTH:
                        robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.WEST));
                        break;
                    case EAST:
                        robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.SOUTH));
                        break;
                    case WEST:
                        robot.setPosition(new Position(p.getxPosition(), p.getyPosition(), Direction.NORTH));
                        break;
                }
                log.debug("Robot success to rotate right to direction " + robot.getPosition().getDirection());

            }
        }
        return robot;
    }
}
