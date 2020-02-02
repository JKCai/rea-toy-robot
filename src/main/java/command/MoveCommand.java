import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveCommand extends Command {

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    @Override
    public AbstractRobot doCommand(AbstractRobot robot) throws Exception {
        if(robot != null) {
            Position p = robot.getPosition();

            switch (p.getDirection()) {
                /*
                    Update the robot coordinate.
                    But also ensure other properities do not change.
                 */
                case NORTH:
                    if (p.checkValidYCoordinate(p.getyPosition() + 1)) {
                        robot.setPosition(new Position(
                                p.getxPosition(), p.getyPosition() + 1, p.getDirection()
                        ));
                        break;
                    } else {
                        log.debug("Robot cannot move due to y axis larger than " + Table.MAX_Y);
                        throw new InvalidPositionException
                                ("Robot cannot move due to y axis larger than " + Table.MAX_Y);
                    }
                case SOUTH:
                    if (p.checkValidYCoordinate(p.getyPosition() - 1)) {
                        robot.setPosition(new Position(
                                p.getxPosition(), p.getyPosition() - 1, p.getDirection()
                        ));
                        break;
                    } else {
                        log.debug("Robot cannot move due to y axis smaller than " + Table.MIN_Y);
                        throw new InvalidPositionException
                                ("Robot cannot move due to y axis smaller than " + Table.MIN_Y);
                    }
                case EAST:
                    if (p.checkValidXCoordinate(p.getxPosition() + 1)) {
                        robot.setPosition(new Position(
                                p.getxPosition() + 1, p.getyPosition(), p.getDirection()
                        ));
                        break;
                    } else {
                        log.debug("Robot cannot move due to x axis larger than " + Table.MAX_X);
                        throw new InvalidPositionException
                                ("Robot cannot move due to x axis larger than " + Table.MAX_X);
                    }
                case WEST:
                    if (p.checkValidXCoordinate(p.getxPosition() - 1)) {
                        robot.setPosition(new Position(
                                p.getxPosition() - 1, p.getyPosition(), p.getDirection()
                        ));
                        break;
                    } else {
                        log.debug("Robot cannot move due to x axis smaller than " + Table.MAX_X);
                        throw new InvalidPositionException
                                ("Robot cannot move due to x axis smaller than " + Table.MIN_X);
                    }
            }
        }
        return robot;
    }
}
