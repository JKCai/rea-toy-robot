import org.junit.Assert;
import org.junit.Test;

public class RightRobotTest {
    @Test
    public void successfulRotateRight() throws Exception{
        Position newPosition;
        Robot robot = new Robot(new Position(2,2, Direction.EAST));
        Command command = new Command();
        newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getDirection().toString(), "SOUTH");
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateRight() throws Exception{
        Robot robot = new Robot(new Position(5,2, Direction.EAST));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateRight_2() throws Exception{
        Robot robot = new Robot(new Position(2,2, Direction.valueOf("REA")));
    }
}
