public class ReportCommand extends Command{
    @Override
    public String reportCommand(Robot robot){
        String output = robot.getPosition().getxPosition() + " " +
                robot.getPosition().getyPosition() + " " +
                robot.getPosition().getDirection();

        return output;
    }
}
