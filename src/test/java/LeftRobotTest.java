import org.junit.Assert;
import org.junit.Test;

public class LeftRobotTest {
    Robot robot = null;

    @Test
    public void successfulRotateLeft_1() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
        Assert.assertEquals("2 2 NORTH", robot.getPositionString());
    }

    @Test
    public void successfulRotateLeft_2() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,NORTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
        Assert.assertEquals("2 2 WEST", robot.getPositionString());
    }

    @Test
    public void successfulRotateLeft_3() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,SOUTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
        Assert.assertEquals("2 2 EAST", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateLeft() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 5,2,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateLeft_2() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2,REA");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
    }

    @Test(expected = InvalidCommandException.class)
    public void failRotateLeft_noDirection() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 2,2");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
    }
}

