import org.junit.Assert;
import org.junit.Test;

public class RightRobotTest {

    Command command = new Command();

    @Test
    public void successfulRotateRight_1() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.EAST);
        newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("SOUTH", newPosition.getDirection().toString());
    }

    @Test
    public void successfulRotateRight_2() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.NORTH);
        newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("EAST", newPosition.getDirection().toString());
    }

    @Test
    public void successfulRotateRight_3() throws Exception{
        Position newPosition;
        Robot robot = command.place(2,2, Direction.SOUTH);
        newPosition = command.rightCommand(robot.getPosition());
        Assert.assertEquals("2", newPosition.getxPosition().toString());
        Assert.assertEquals("2", newPosition.getyPosition().toString());
        Assert.assertEquals("WEST", newPosition.getDirection().toString());
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
