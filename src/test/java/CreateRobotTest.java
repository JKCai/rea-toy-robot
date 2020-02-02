import org.junit.Assert;
import org.junit.Test;

public class CreateRobotTest {

//    Test robot can be successfully created
    @Test
    public void successfulCreationTest() throws Exception{
        Position position = new Position(0, 0, Direction.NORTH);
        Robot robot = new Robot();
        robot.setPosition(position);
        Assert.assertEquals(robot.getPosition().getxPosition().toString(), "0");
        Assert.assertEquals(robot.getPosition().getyPosition().toString(), "0");
        Assert.assertEquals(robot.getPosition().getDirection(), Direction.NORTH);
    }

//    Test robot cannot be created due to exceed x_axis boundary.

    @Test
    public void failCreationTest_ExceedMaxX() throws InvalidPositionException{
        Position position = new Position(5, 0, Direction.NORTH);
        Assert.assertNull(position.getxPosition());
        Assert.assertNull(position.getyPosition());
        Assert.assertNull(position.getDirection());
    }

    @Test
    public void failCreationTest_ExceedMinX() throws InvalidPositionException{
        Position position = new Position(-1, 0, Direction.NORTH);
        Assert.assertNull(position.getxPosition());
        Assert.assertNull(position.getyPosition());
        Assert.assertNull(position.getDirection());
    }

    @Test
    public void failCreationTest_ExceedMaxY() throws InvalidPositionException{
        Position position = new Position(0, 5, Direction.NORTH);
        Assert.assertNull(position.getxPosition());
        Assert.assertNull(position.getyPosition());
        Assert.assertNull(position.getDirection());
    }

    @Test
    public void failCreationTest_ExceedMinY() throws InvalidPositionException{
        Position position = new Position(0, -1, Direction.NORTH);
        Assert.assertNull(position.getxPosition());
        Assert.assertNull(position.getyPosition());
        Assert.assertNull(position.getDirection());

    }
}
