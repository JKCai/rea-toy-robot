import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Position {
    private Integer xPosition;
    private Integer yPosition;
    private Direction direction;

    private final Logger log = LoggerFactory.getLogger(LeftCommand.class);

    public Position(Integer x, Integer y, Direction direction) throws Exception{
        if (checkValidXCoordinate(x) && checkValidYCoordinate(y)){
            this.xPosition = x;
            this.yPosition = y;
        }else{
            throw new InvalidPositionException("Exceed boundary");
        }

        if (!checkValidDirection(direction)){
            log.debug("Invalid direction");
        }else {
            this.direction = direction;
        }
    }

//    Check if the current direction is within the options
    public boolean checkValidDirection(Direction d){
        boolean isValid = false;
        for (Direction direction : Direction.values()) {
            if (direction.equals(d)){
                isValid = true;
            }
        }
        return isValid;
    }

//    Check if the the X position is within the range
    public boolean checkValidXCoordinate(Integer val){
        if (val > Table.MAX_X || val < Table.MIN_X){
            return false;
        }else{
            return true;
        }
    }

//    Check if the Y position is within the range
    public boolean checkValidYCoordinate(Integer val){
        if (val > Table.MAX_Y || val < Table.MIN_Y){
            return false;
        }else {
            return true;
        }
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
