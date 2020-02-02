import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveRobotTest {
    PlaceCommand placeCommand;
    MoveCommand moveCommand;

    @Before
    public void setUp(){
        this.placeCommand  = new PlaceCommand();
        this.moveCommand = new MoveCommand();
    }

    /*
        Test Robot successfully move to north
     */
    @Test
    public void successfulMoveNorthTest() throws Exception{
        Robot robot = placeCommand.place(0, 0, Direction.NORTH);
        robot.setPosition(moveCommand.move(robot.getPosition()));
        Assert.assertEquals("0 1 NORTH", robot.getPositionString());
    }

    /*
        Test Robot fail to move to north due to exceed boundary
     */
    @Test(expected = InvalidPositionException.class)
    public void failMoveNorthTest() throws Exception{
        Robot robot = placeCommand.place(0, 4, Direction.NORTH);
        robot.setPosition(moveCommand.move(robot.getPosition()));
    }

    /*
        Test Robot successfully move to south
     */
    @Test
    public void successfulMoveSouthTest() throws Exception{
        Robot robot = placeCommand.place(4, 4, Direction.SOUTH);
        robot.setPosition(moveCommand.move(robot.getPosition()));
        Assert.assertEquals("4 3 SOUTH", robot.getPositionString());
    }

    /*
        Test Robot fail to move to south due to exceed boundary
     */
    @Test(expected = InvalidPositionException.class)
    public void failMoveSouthTest() throws Exception{
        Robot robot = placeCommand.place(0, 0, Direction.SOUTH);
        robot.setPosition(moveCommand.move(robot.getPosition()));
    }

    /*
        Test Robot successfully move to west
     */
    @Test
    public void successfulMoveWestTest() throws Exception{
        Robot robot = placeCommand.place(4, 4, Direction.WEST);
        robot.setPosition(moveCommand.move(robot.getPosition()));
        Assert.assertEquals("3 4 WEST", robot.getPositionString());
    }

    /*
        Test Robot fail to move to west due to exceed boundary
     */
    @Test(expected = InvalidPositionException.class)
    public void failMoveWestTest() throws Exception{
        Robot robot = placeCommand.place(0, 0, Direction.WEST);
        robot.setPosition(moveCommand.move(robot.getPosition()));
    }

    /*
        Test Robot successfully move to east
     */
    @Test
    public void successfulMoveEastTest() throws Exception{
        Robot robot = placeCommand.place(0, 0, Direction.EAST);
        robot.setPosition(moveCommand.move(robot.getPosition()));
        Assert.assertEquals("1 0 EAST", robot.getPositionString());
    }

    /*
        Test Robot fail to move to east due to exceed boundary
     */
    @Test(expected = InvalidPositionException.class)
    public void failMoveEastTest() throws Exception{
        Robot robot = placeCommand.place(4, 0, Direction.EAST);
        robot.setPosition(moveCommand.move(robot.getPosition()));
    }
}
