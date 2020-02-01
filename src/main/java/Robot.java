public class Robot {
    private Position position;

    public Robot(){

    }

    public Robot(Position p){
        this.position = p;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position != null){
            this.position = position;
        }else{
            System.out.println("error: invalid position in entered.");
        }
    }

}
