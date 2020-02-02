import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReportRobotTest {

    PlaceCommand placeCommand;
    ReportCommand reportCommand;
    MoveCommand moveCommand;
    LeftCommand leftCommand;
    RightCommand rightCommand;

    ArrayList<Robot> robotList = new ArrayList<Robot>();


    @Before
    public void setup(){
        this.placeCommand = new PlaceCommand();
        this.reportCommand = new ReportCommand();
        this.moveCommand = new MoveCommand();
        this.leftCommand = new LeftCommand();
        this.rightCommand = new RightCommand();
    }

    /*
        Test report successful prints output after Place Command
     */
    @Test
    public void successfulPrintReportPlace() throws Exception{
        Robot robot = placeCommand.place(1 ,0, Direction.WEST);
        String output = reportCommand.reportCommand(robot);
        Assert.assertEquals("1 0 WEST", output);
    }

    /*
        Test report successfully prints output after Move Command
     */
    @Test
    public void successfulPrintReportMove() throws Exception{
        Robot robot = placeCommand.place(1 ,0, Direction.WEST);
        Position newPosition = moveCommand.move(robot.getPosition());
        String output = reportCommand.reportCommand(robot);
        Assert.assertEquals("0 0 WEST", output);
    }

    /*
        Test report successfully prints output after Left Command
     */
    @Test
    public void successfulPrintReportLeft() throws Exception{
        Robot robot = placeCommand.place(1 ,0, Direction.WEST);
        Position newPosition = leftCommand.leftCommand(robot.getPosition());
        String output = reportCommand.reportCommand(robot);
        Assert.assertEquals("1 0 SOUTH", output);
    }

    /*
        Test report successfully prints output after Right Command
     */
    @Test
    public void successfulPrintReportRight() throws Exception {
        Robot robot = placeCommand.place(1 ,0, Direction.WEST);
        Position newPosition = rightCommand.rightCommand(robot.getPosition());
        String output = reportCommand.reportCommand(robot);
        Assert.assertEquals("1 0 NORTH", output);
    }

    /*
        Test report successfully prints output after All Commands
     */
    @Test
    public void successfulPrintReportFull() throws Exception {
        Robot robot = placeCommand.place(1 ,0, Direction.WEST);
        moveCommand.move(robot.getPosition());
        rightCommand.rightCommand(robot.getPosition());
        moveCommand.move(robot.getPosition());
        leftCommand.leftCommand(robot.getPosition());
        String output = reportCommand.reportCommand(robot);
        Assert.assertEquals("0 1 WEST", output);
    }

    @Test
    public void successfullPrintReportFullForMultiRobots() throws Exception{
        Robot robot1 = placeCommand.place(4,0, Direction.EAST);
        Robot robot2 = placeCommand.place(0,4, Direction.WEST);
        robotList.add(robot1);
        robotList.add(robot2);

        for(int robotNum = 1; robotNum <= robotList.size(); robotNum++){
            leftCommand.leftCommand(robotList.get(robotNum-1).getPosition());
            moveCommand.move(robotList.get(robotNum-1).getPosition());
            rightCommand.rightCommand(robotList.get(robotNum-1).getPosition());
        }

        String robot1_position = robotList.get(0).getPositionString();
        String robot2_position = robotList.get(1).getPositionString();

        Assert.assertEquals(2, robotList.size());
        Assert.assertEquals("4 1 EAST", robot1_position);
        Assert.assertEquals("0 3 WEST", robot2_position);
    }
}
