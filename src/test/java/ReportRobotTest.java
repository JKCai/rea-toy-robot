import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReportRobotTest {
    AbstractRobot robot = null;

    @Test
    public void successfulPrintReportPlace() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 1,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Assert.assertEquals("1 0 WEST", robot.getPositionString());
    }

    @Test
    public void successfulPrintReportMove() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 1,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Assert.assertEquals("0 0 WEST", robot.getPositionString());
    }

    @Test
    public void successfulPrintReportMove_Mannual() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 1,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Position p = robot.getPosition();
        Assert.assertEquals("0", p.getxPosition().toString());
        Assert.assertEquals("0", p.getxPosition().toString());
        Assert.assertEquals("WEST", p.getDirection().toString());
    }

    @Test
    public void successfulPrintReportLeft() throws Exception{
        Command c = CommandFactory.getCommand("PLACE 1,0,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Assert.assertEquals("1 0 SOUTH", robot.getPositionString());
    }

    @Test
    public void successfulPrintReportRight() throws Exception {
        Command c = CommandFactory.getCommand("PLACE 1,0,EAST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Assert.assertEquals("1 0 SOUTH", robot.getPositionString());
    }

    @Test
    public void successfulPrintReportFull() throws Exception {
        Command c = CommandFactory.getCommand("PLACE 2,2,WEST");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("LEFT");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("MOVE");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("RIGHT");
        robot = c.doCommand(robot);
        c = CommandFactory.getCommand("REPORT");
        robot = c.doCommand(robot);
        Assert.assertEquals("2 1 WEST", robot.getPositionString());
    }

}
