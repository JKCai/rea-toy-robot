import org.junit.Assert;
import org.junit.Test;

public class CreateRobotTest {

    Command command = new Command();

//    Test robot can be successfully created
    @Test
    public void successfulCreationTest() throws Exception{
        Robot robot = command.place(0, 0, Direction.NORTH);
        Assert.assertEquals(robot.getPosition().getxPosition().toString(), "0");
        Assert.assertEquals(robot.getPosition().getyPosition().toString(), "0");
        Assert.assertEquals(robot.getPosition().getDirection(), Direction.NORTH);
    }

//    Test robot cannot be created due to exceed x_axis boundary.

    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxX() throws Exception {
        Robot robot = command.place(5, 0, Direction.NORTH);
    }

//    Test robot cannot be created due to exceed x_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinX() throws Exception{
        Robot robot = command.place(-1, 0, Direction.NORTH);
    }

//    Test robot cannot be created due to exceed y_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxY() throws Exception{
        Robot robot = command.place(0, 5, Direction.NORTH);
    }

//    Test robot cannot be created due to exceed y_axis boundary.
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinY() throws Exception{
        Robot robot = command.place(0, -1, Direction.NORTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreationTest_invalidDirection() throws Exception{
        Robot robot = command.place(4, 4, Direction.valueOf("REA"));
    }
}
