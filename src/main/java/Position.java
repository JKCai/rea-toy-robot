public class Position {
    private Integer xPosition;
    private Integer yPosition;
    private Direction direction;

    public Position(Integer x, Integer y, Direction direction) throws InvalidPositionException{
        if (x > Table.MAX_X || x < Table.MIN_X || y > Table.MAX_Y || y < Table.MIN_Y){
            System.out.println("error: exceed boundary");

        }else{
            this.xPosition = x;
            this.yPosition = y;
            this.direction = direction;
        }
    }

    public void getCurrentPosition(Position p){
        this.xPosition = p.getxPosition();
        this.yPosition = p.getyPosition();
        this.direction = p.getDirection();
    }


    public Integer getxPosition() { return xPosition; }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getyPosition() { return yPosition; }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public Direction getDirection() { return direction; }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
