import org.junit.Assert;
import org.junit.Test;

//import java.io.ByteArrayOutputStream;

public class ReportRobotTest {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Command command = new Command();

    @Test
    public void successfulPrintReportPlace() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        String output = command.reportCommand(robot);
        Assert.assertEquals("1 0 WEST", output);
    }

    @Test
    public void successfulPrintReportMove() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.move(robot.getPosition());
        String output = command.reportCommand(robot);
        Assert.assertEquals("0 0 WEST", output);
    }

    @Test
    public void successfulPrintReportLeft() throws Exception{
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.leftCommand(robot.getPosition());
        String output = command.reportCommand(robot);
        Assert.assertEquals("1 0 SOUTH", output);
    }

    @Test
    public void successfulPrintReportRight() throws Exception {
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.rightCommand(robot.getPosition());
        String output = command.reportCommand(robot);
        Assert.assertEquals("1 0 NORTH", output);
    }

    @Test
    public void successfulPrintReportFull() throws Exception {
        Robot robot = command.place(1 ,0, Direction.WEST);
        Position newPosition = command.move(robot.getPosition());
        String output = command.reportCommand(robot);
        Assert.assertEquals("0 0 WEST", output);
    }

}
