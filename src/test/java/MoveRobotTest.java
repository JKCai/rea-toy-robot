import org.junit.Assert;
import org.junit.Test;

public class MoveRobotTest {
    Command command = new Command();

    @Test
    public void successfulMoveNorthTest() throws Exception{
        Position newPosition = null;
        Robot robot = command.place(0, 0, Direction.NORTH);
        newPosition = command.move(robot.getPosition());
        Assert.assertEquals("0", newPosition.getxPosition().toString());
        Assert.assertEquals("1", newPosition.getyPosition().toString());
        Assert.assertEquals(Direction.NORTH, newPosition.getDirection());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveNorthTest() throws Exception{
        Robot robot = command.place(0, 4, Direction.NORTH);
        command.move(robot.getPosition());
    }

    @Test
    public void successfulMoveSouthTest() throws Exception{
        Position newPosition = null;
        Robot robot = command.place(4, 4, Direction.SOUTH);
        newPosition = command.move(robot.getPosition());
        robot.setPosition(newPosition);
        Assert.assertEquals("4", robot.getPosition().getxPosition().toString());
        Assert.assertEquals("3", robot.getPosition().getyPosition().toString());
        Assert.assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveSouthTest() throws Exception{
        Robot robot = command.place(0, 0, Direction.SOUTH);
        Command command = new Command();
        command.move(robot.getPosition());
    }

    @Test
    public void successfulMoveWestTest() throws Exception{
        Position newPosition = null;
        Robot robot = command.place(4, 4, Direction.WEST);
        newPosition = command.move(robot.getPosition());
        Assert.assertEquals("3", newPosition.getxPosition().toString());
        Assert.assertEquals("4", newPosition.getyPosition().toString());
        Assert.assertEquals(Direction.WEST, newPosition.getDirection());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveWestTest() throws Exception{
        Robot robot = command.place(0, 0, Direction.WEST);
        command.move(robot.getPosition());
    }

    @Test
    public void successfulMoveEastTest() throws Exception{
        Position newPosition = null;
        Robot robot = command.place(0, 0, Direction.EAST);
        newPosition = command.move(robot.getPosition());
        Assert.assertEquals("1", newPosition.getxPosition().toString());
        Assert.assertEquals("0", newPosition.getyPosition().toString());
        Assert.assertEquals(Direction.EAST, newPosition.getDirection());
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveEastTest() throws Exception{
        Robot robot = command.place(4, 0, Direction.EAST);
        command.move(robot.getPosition());
    }
}
