import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RightRobotTest {

    Command command = new Command();
    ArrayList<Robot> robotList = new ArrayList<Robot>();

    /*
        Test one robot can successfully rotate from east to south
     */
    @Test
    public void successfulOneRotateRight() throws Exception{
        Robot robot = command.place(2,2, Direction.EAST);
        command.rightCommand(robot.getPosition());
        Assert.assertEquals("2 2 SOUTH", robot.getPositionString());
    }

    /*
        Test two robots can successfully rotate from north east to east and from southto west
     */
    @Test
    public void successfulTwoRotateRight() throws Exception{
       Robot robot1 = command.place(0,4, Direction.NORTH);
        Robot robot2 = command.place(4, 0, Direction.SOUTH);
        robotList.add(robot1);
        robotList.add(robot2);
        command.rightCommand(robotList.get(0).getPosition());
        command.rightCommand(robotList.get(1).getPosition());
        String robot1_position = robotList.get(0).getPositionString();
        String robot2_position = robotList.get(1).getPositionString();

        Assert.assertEquals(2, robotList.size());
        Assert.assertEquals("0 4 EAST", robot1_position);
        Assert.assertEquals("4 0 WEST", robot2_position);
    }

    /*
        Test Robot fail to rotate to right because the position is invalid
     */
    @Test(expected = InvalidPositionException.class)
    public void failRotateRight() throws Exception{
        Robot robot = command.place(5,2, Direction.EAST);
        command.rightCommand(robot.getPosition());
    }

    /*
        Test Robot fail to rotate to right because the position is invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void failRotateRight_2() throws Exception{
        Robot robot = command.place(2,2, Direction.valueOf("REA"));
        command.rightCommand(robot.getPosition());
    }
}
