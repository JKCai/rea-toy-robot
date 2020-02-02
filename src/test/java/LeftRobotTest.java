import org.junit.Assert;
import org.junit.Test;

public class LeftRobotTest {

    Command command = new Command();

    @Test
    public void successfulRotateLeft() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.EAST);
        newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals(newPosition.getDirection().toString(), "NORTH");
    }

    @Test(expected = InvalidPositionException.class)
    public void failRotateLeft() throws Exception{
        Robot robot = command.place(5,2, Direction.EAST);
        command.leftCommand(robot.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failRotateLeft_2() throws Exception{
        Robot robot = command.place(5,2, Direction.valueOf("REA"));
        command.leftCommand(robot.getPosition());
    }
}

