import org.junit.Assert;
import org.junit.Test;

public class MoveRobotTest {
    @Test
    public void successfulMoveNorthTest() throws Exception{
        Position newPosition = null;
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));
        newPosition = robot.move();
        Assert.assertEquals(newPosition.getxPosition().toString(), "0");
        Assert.assertEquals(newPosition.getyPosition().toString(), "1");
        Assert.assertEquals(newPosition.getDirection(), Direction.NORTH);
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveNorthTest() throws Exception{
        Robot robot = new Robot(new Position(0, 4, Direction.NORTH));
        Position newPosition = robot.move();
    }

    @Test
    public void successfulMoveSouthTest() throws Exception{
        Position newPosition = null;
        Robot robot = new Robot(new Position(4, 4, Direction.SOUTH));
        newPosition = robot.move();
        Assert.assertEquals(newPosition.getxPosition().toString(), "4");
        Assert.assertEquals(newPosition.getyPosition().toString(), "3");
        Assert.assertEquals(newPosition.getDirection(), Direction.SOUTH);
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveSouthTest() throws Exception{
        Robot robot = new Robot(new Position(0, 0, Direction.SOUTH));
        Position newPosition = robot.move();
    }

    @Test
    public void successfulMoveWestTest() throws Exception{
        Position newPosition = null;
        Robot robot = new Robot(new Position(4, 4, Direction.WEST));
        newPosition = robot.move();
        Assert.assertEquals(newPosition.getxPosition().toString(), "3");
        Assert.assertEquals(newPosition.getyPosition().toString(), "4");
        Assert.assertEquals(newPosition.getDirection(), Direction.WEST);
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveWestTest() throws Exception{
        Robot robot = new Robot(new Position(0, 0, Direction.WEST));
        Position newPosition = robot.move();
    }

    @Test
    public void successfulMoveEastTest() throws Exception{
        Position newPosition = null;
        Robot robot = new Robot(new Position(0, 0, Direction.EAST));
        newPosition = robot.move();
        Assert.assertEquals(newPosition.getxPosition().toString(), "1");
        Assert.assertEquals(newPosition.getyPosition().toString(), "0");
        Assert.assertEquals(newPosition.getDirection(), Direction.EAST);
    }

    @Test(expected = InvalidPositionException.class)
    public void failMoveEastTest() throws Exception{
        Robot robot = new Robot(new Position(4, 0, Direction.EAST));
        Position newPosition = robot.move();
    }
}
