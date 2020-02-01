import org.junit.Assert;
import org.junit.Test;

public class ReportRobotTest {
    Command command = new Command();

    @Test
    public void successfulPrintReportPlace() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        Assert.assertEquals(robot.getPosition().getxPosition().toString(), "1");
        Assert.assertEquals(robot.getPosition().getyPosition().toString(), "0");
        Assert.assertEquals(robot.getPosition().getDirection(), Direction.WEST);
    }

    @Test
    public void successfulPrintReportMove() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.move(robot.getPosition());
        Assert.assertEquals(newPosition.getxPosition().toString(), "0");
        Assert.assertEquals(newPosition.getyPosition().toString(), "0");
        Assert.assertEquals(newPosition.getDirection(), Direction.WEST);
    }

    @Test
    public void successfulPrintReportLeft() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getxPosition().toString(), "1");
        Assert.assertEquals(newPosition.getyPosition().toString(), "0");
        Assert.assertEquals(newPosition.getDirection(), Direction.SOUTH);
    }

    @Test
    public void successfulPrintReportRight() throws Exception {
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getxPosition().toString(), "1");
        Assert.assertEquals(newPosition.getyPosition().toString(), "0");
        Assert.assertEquals(newPosition.getDirection(), Direction.NORTH);
    }

    @Test
    public void successfulPrintReportFull() throws Exception {
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.move(robot.getPosition());
        Assert.assertEquals(newPosition.getxPosition().toString(), "0");
        Assert.assertEquals(newPosition.getyPosition().toString(), "0");
        Assert.assertEquals(newPosition.getDirection(), Direction.WEST);
    }

}
