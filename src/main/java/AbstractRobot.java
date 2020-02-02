public abstract class AbstractRobot {

    protected Position position;

    public abstract boolean isNil();

    public abstract String getPositionString();

    public abstract Position getPosition();

    public abstract void setPosition(Position position) throws Exception;
}
