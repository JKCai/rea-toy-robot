public class RobotFactory {

    public static AbstractRobot getRobot(Position position){
        if (position != null){
            return new Robot(position);
        }else{
            return new NullRobot();
        }

    }
}
