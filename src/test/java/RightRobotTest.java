import org.junit.Assert;
import org.junit.Test;

public class RightRobotTest {

    Command command = new Command();

    @Test
    public void successfulRotateRight() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.EAST);
        newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getDirection().toString(), "SOUTH");
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateRight() throws Exception{
        Robot robot = command.place(5,2, Direction.EAST);
        command.rightCommand(robot.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateRight_2() throws Exception{
        Robot robot = command.place(2,2, Direction.valueOf("REA"));
        command.rightCommand(robot.getPosition());
    }
}
