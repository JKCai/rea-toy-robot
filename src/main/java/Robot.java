public class Robot {
    private Position position;

    public Robot(Position p){
        this.position = p;
    }

    public Position getPosition() {
        return position;
    }

    public String getPositionString(){
        String stringPosition = this.position.getxPosition() + " " +
                                this.position.getyPosition() + " " +
                                this.position.getDirection();
        return stringPosition;
    }

    public void setPosition(Position position) throws Exception{
        if (position != null){
            this.position = position;
        }else{
            throw new InvalidPositionException("Invalid position in entered.");
        }
    }

}
