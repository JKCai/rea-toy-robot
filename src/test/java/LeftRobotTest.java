import org.junit.Assert;
import org.junit.Test;

public class LeftRobotTest {

    Command command = new Command();

    @Test
    public void successfulRotateLeft_1() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.EAST);
        newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("NORTH", newPosition.getDirection().toString());
    }

    @Test
    public void successfulRotateLeft_2() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.NORTH);
        newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("WEST", newPosition.getDirection().toString());
    }

    @Test
    public void successfulRotateLeft_3() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.SOUTH);
        newPosition = command.leftCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("EAST", newPosition.getDirection().toString());
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

