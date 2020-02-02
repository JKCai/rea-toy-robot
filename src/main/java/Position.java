public class Position {
    private Integer xPosition;
    private Integer yPosition;
    private Direction direction;

    public Position(Integer x, Integer y, Direction direction) throws Exception{
        if (checkValidXCoordinate(x) && checkValidYCoordinate(y)){
            this.xPosition = x;
            this.yPosition = y;
        }else{
            throw new InvalidPositionException("error: exceed boundary");
        }

        if (!checkValidDirection(direction)){
            throw new InvalidDirectionException("error: invalid direction");
        }else {
            this.direction = direction;
        }
    }

//    Check if the current direction is within the options
    public boolean checkValidDirection(Direction d){
        for (Direction direction : Direction.values()) {
            if (direction.equals(d)){
                return true;
            }
        }
        return false;
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

//    When move command is called, update the current robot coordinate
    public Position updateCoordinate() throws Exception{
        Position newPosition = null;
        if(this.direction == null || !checkValidDirection(this.direction)){
            throw new InvalidDirectionException("error: invalid direction");
        }else {
            switch(this.direction){
                /*
                    Update the robot coordinate.
                    But also ensure other properities do not change.
                 */
                case NORTH:
                    if (checkValidYCoordinate(this.yPosition + 1)){
                        this.yPosition = this.yPosition + 1;
                        this.xPosition = this.xPosition;
                        this.direction = this.direction;
                        break;
                    } else{
                        throw new InvalidPositionException("error: robot cannot move due to y axis larger than " + Table.MAX_Y);
                    }
                case SOUTH:
                    if (checkValidYCoordinate(this.yPosition - 1)){
                        this.yPosition = this.yPosition - 1;
                        this.xPosition = this.xPosition;
                        this.direction = this.direction;
                        break;
                    } else{
                        throw new InvalidPositionException("error: robot cannot move due to y axis smaller than " + Table.MIN_Y);
                    }
                case EAST:
                    if (checkValidXCoordinate(this.xPosition + 1)){
                        this.xPosition = this.xPosition + 1;
                        this.yPosition = this.yPosition;
                        this.direction = this.direction;
                        break;
                    } else{
                        throw new InvalidPositionException("error: robot cannot move due to x axis larger than " + Table.MAX_X);
                    }
                case WEST:
                    if (checkValidXCoordinate(this.xPosition - 1)){
                        this.xPosition = this.xPosition - 1;
                        this.yPosition = this.yPosition;
                        this.direction = this.direction;
                        break;
                    } else{
                        throw new InvalidPositionException("error: robot cannot move due to x axis smaller than "+ Table.MIN_X);
                    }
            }
        }

        try {
            newPosition = new Position(this.xPosition, this.yPosition, this.direction);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newPosition;
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
