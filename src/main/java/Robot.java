public class Robot {
    private Position position;

    public Robot(){

    }

    public Position move() throws Exception {
        this.position = position.updateCoordinate();
        return position;

    }

    public Robot(Position p){
        this.position = p;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) throws Exception{
        if (position != null){
            this.position = position;
        }else{
            throw new InvalidPositionException("error: invalid position in entered.");
        }
    }

}
