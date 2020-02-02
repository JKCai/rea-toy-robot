import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PlaceRobotTest {

    AbstractRobot robot = null;

    /*
        test one robot can be created successfully
     */
    @Test
    public void successfulCreationTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,NORTH");
        robot = c.doCommand(robot);
        Assert.assertFalse(robot.isNil());
        Assert.assertEquals("0 0 NORTH", robot.getPositionString());
    }

    /*
        Test robot cannot be created due to exceed x_axis boundary.
     */
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxX() throws Exception {
        Command c = CommandFactory.getCommand("PLACE 5,0,NORTH");
        robot = c.doCommand(robot);
    }

    //    Test robot cannot be created due to exceed x_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinX() throws Exception{
        Command c = CommandFactory.getCommand("PLACE -1,0,NORTH");
        robot = c.doCommand(robot);
    }

    //    Test robot cannot be created due to exceed y_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxY() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,5,NORTH");
        robot = c.doCommand(robot);
    }

    //    Test robot cannot be created due to exceed y_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinY() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,-1,NORTH");
        robot = c.doCommand(robot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreationTest_invalidDirection() throws Exception{
        Command c = CommandFactory.getCommand("PLACE -1,0,REA");
        robot = c.doCommand(robot);
    }

    @Test(expected = InvalidCommandException.class)
    public void failCreationTest_noDirection() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0");
        robot = c.doCommand(robot);
    }

    @Test(expected = InvalidCommandException.class)
    public void failCreationTest_noArugments() throws Exception{
        Command c = CommandFactory.getCommand("PLACE");
        robot = c.doCommand(robot);
    }

    @Test
    public void failCreationTest_nullPosition() throws Exception{
        Position position = null;
        AbstractRobot robot = RobotFactory.getRobot(position);
        robot.getPositionString();
        robot.getPosition();
        robot.setPosition(null);
        Assert.assertTrue(robot.isNil());
    }

}
