import org.junit.Assert;
import org.junit.Test;

public class RightRobotTest {
    AbstractRobot robot = null;

    @Test
    public void successfulRotateRightOnce() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
        Assert.assertEquals("4 0 NORTH", robot.getPositionString());
    }

    @Test
    public void successfulRotateRightTwice() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,NORTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
        Assert.assertEquals("2 2 SOUTH", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateRight() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 5,2,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateRight_2() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,REA");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
    }

    @Test(expected = InvalidCommandException.class)
    public void failRotateRight_noDirection() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
    }
}
