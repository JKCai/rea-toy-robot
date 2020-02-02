import org.junit.Assert;
import org.junit.Test;

public class LeftRobotTest {
    @Test
    public void successfulRotateLeft() throws Exception{
        Position newPosition;
        Robot robot = new Robot(new Position(2,2, Direction.EAST));
        Command command = new Command();
        newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getDirection().toString(), "NORTH");
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateLeft() throws Exception{
        Robot robot = new Robot(new Position(5,2, Direction.EAST));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateLeft_2() throws Exception{
        Robot robot = new Robot(new Position(5,2, Direction.valueOf("REA")));
    }
}

