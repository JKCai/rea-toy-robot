public class NullRobot extends AbstractRobot {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getPositionString() {
        return "No Position - due to null robot";
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public void setPosition(Position position) throws Exception {
        System.out.println("no robot to set position");
    }


}
