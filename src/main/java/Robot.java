public class Robot extends AbstractRobot{
    private Position position;

    public Robot(Position p){
        this.position = p;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String getPositionString(){
        String stringPosition = this.position.getxPosition() + " " +
                                this.position.getyPosition() + " " +
                                this.position.getDirection();
        return stringPosition;
    }

    @Override
    public void setPosition(Position position) throws Exception{
        if (position != null){
            this.position = position;
        }else{
            throw new InvalidPositionException("Invalid position in entered.");
        }
    }

}
