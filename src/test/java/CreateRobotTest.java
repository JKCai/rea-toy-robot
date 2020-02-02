import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateRobotTest {

    PlaceCommand placeCommand;
    ArrayList<Robot> robotList = new ArrayList<Robot>();

    @Before
    public void setUp(){
        this.placeCommand  = new PlaceCommand();
    }

    /*
        test one robot can be created successfully
     */
    @Test
    public void successfulCreateOneRobotTest() throws Exception{
        Robot robot = placeCommand.place(0, 0, Direction.NORTH);
        Assert.assertEquals("0 0 NORTH", robot.getPositionString());
    }

    /*
        test two robots can be created successfully
     */
    @Test
    public void successfulCreateTwoRobotTest() throws Exception{
        Robot robot1 = placeCommand.place(0, 0, Direction.NORTH);
        Robot robot2 = placeCommand.place(1, 1, Direction.EAST);
        robotList.add(robot1);
        robotList.add(robot2);
        String robot1_position = robotList.get(0).getPositionString();
        String robot2_position = robotList.get(1).getPositionString();

        Assert.assertEquals(2, robotList.size());
        Assert.assertEquals("0 0 NORTH", robot1_position);
        Assert.assertEquals("1 1 EAST", robot2_position);

    }

    /*
        Test robot cannot be created due to exceed x_axis boundary.
     */
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxX() throws Exception {
        Robot robot = placeCommand.place(5, 0, Direction.NORTH);
    }

    /*
        Test robot cannot be created due to exceed x_axis boundary.
     */
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinX() throws Exception{
        Robot robot = placeCommand.place(-1, 0, Direction.NORTH);
    }

    /*
        Test robot cannot be created due to exceed y_axis boundary.
     */
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMaxY() throws Exception{
        Robot robot = placeCommand.place(0, 5, Direction.NORTH);
    }

    /*
        Test robot cannot be created due to exceed y_axis boundary.
     */
    @Test(expected = InvalidPositionException.class)
    public void failCreationTest_ExceedMinY() throws Exception{
        Robot robot = placeCommand.place(0, -1, Direction.NORTH);
    }

    /*
        Test robot cannot be created due to invalid direction.
     */
    @Test(expected = IllegalArgumentException.class)
    public void failCreationTest_invalidDirection() throws Exception{
        Robot robot = placeCommand.place(4, 4, Direction.valueOf("REA"));
    }
}
