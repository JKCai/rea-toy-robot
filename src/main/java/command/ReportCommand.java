import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportCommand extends Command {

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    @Override
    public AbstractRobot doCommand(AbstractRobot robot) throws Exception{
        if (robot.isNil()){
            log.debug("No robot - no report output");
        }else {
            System.out.println(robot.getPositionString());
        }
        log.debug("robot report: " + robot.getPositionString());
        return robot;
    }

}
