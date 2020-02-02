import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LeftRobotTest {

    PlaceCommand placeCommand;
    LeftCommand leftCommand;
    ArrayList<Robot> robotList = new ArrayList<Robot>();

    @Before
    public void setUp(){
        this.placeCommand  = new PlaceCommand();
        this.leftCommand = new LeftCommand();
    }

    /*
        Test one robot can successfully rotate from east to north
     */
    @Test
    public void successfulOneRotateLeft() throws Exception{
        Robot robot = placeCommand.place(2,2, Direction.EAST);
        leftCommand.leftCommand(robot.getPosition());
        Assert.assertEquals("2 2 NORTH", robot.getPositionString());
    }

    /*
        Test two robots can successfully rotate from north east to west and from south to east
     */
    @Test
    public void successfulRotateLeft_2() throws Exception{
        Robot robot1 = placeCommand.place(2,2, Direction.NORTH);
        Robot robot2 = placeCommand.place(3,3, Direction.SOUTH);
        robotList.add(robot1);
        robotList.add(robot2);
        leftCommand.leftCommand(robotList.get(0).getPosition());
        leftCommand.leftCommand(robotList.get(1).getPosition());
        String robot1_position = robotList.get(0).getPositionString();
        String robot2_position = robotList.get(1).getPositionString();

        Assert.assertEquals(2, robotList.size());
        Assert.assertEquals("2 2 WEST", robot1_position);
        Assert.assertEquals("3 3 EAST", robot2_position);
    }


    /*
        Test Robot fail to rotate to left because the position is invalid
     */
    @Test(expected = InvalidPositionException.class)
    public void failRotateLeft() throws Exception{
        Robot robot = placeCommand.place(5,2, Direction.EAST);
        leftCommand.leftCommand(robot.getPosition());
    }

    /*
        Test Robot fail to rotate to left because the direction is invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void failRotateLeft_2() throws Exception{
        Robot robot = placeCommand.place(5,2, Direction.valueOf("REA"));
        leftCommand.leftCommand(robot.getPosition());
    }
}

