import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveRobotTest {
    AbstractRobot robot = null;

    @Test
    public void successfulMoveNorthTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,NORTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        Assert.assertEquals("0 1 NORTH", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveNorthTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,4,NORTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
    }

    @Test
    public void successfulMoveSouthTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,4,SOUTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        Assert.assertEquals("4 3 SOUTH", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveSouthTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,SOUTH");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
    }

    @Test
    public void successfulMoveWestTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,4,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        Assert.assertEquals("3 4 WEST", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveWestTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
    }

    @Test
    public void successfulMoveEastTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        Assert.assertEquals("1 0 EAST", robot.getPositionString());
    }

    @Test
    public void successfulMoveEastTest_mannual() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 0,0,EAST");
        robot = c.doCommand(robot);
        Position p = robot.getPosition();
        p.setxPosition(1);
        p.setyPosition(0);
        p.setDirection(Direction.EAST);
        robot.setPosition(p);
        Assert.assertEquals("1 0 EAST", robot.getPositionString());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveEastTest() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,0,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
    }

    @Test(expected = NullPointerException.class)
    public void failMoveTest_invaildMove() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,0,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOOVE");
        robot = c.doCommand(robot);
    }

    @Test(expected = NullPointerException.class)
    public void failMoveTest_noCommand() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 4,0,EAST");
        robot = c.doCommand(robot);
        String commandString = null;
        c = CommandFactory.getCommand(commandString);
        robot = c.doCommand(robot);
    }
}
