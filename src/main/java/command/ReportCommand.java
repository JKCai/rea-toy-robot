import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportCommand extends Command {

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    @Override
    public Robot doCommand(Robot robot) throws Exception{
        if (robot == null){
            log.debug("No robot - no report output");
        }else if(robot.getPosition() == null){
            log.debug("Invalid position - no report output");
            throw new InvalidPositionException("Invalid position");
        }else {
            System.out.println(robot.getPositionString());
        }
        log.debug("robot report: " + robot.getPositionString());
        return robot;
    }

}
