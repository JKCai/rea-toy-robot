public class Command {

    public Command(){

    }

    public Robot place(Integer xPosition, Integer yPosition, Direction direction) throws Exception{
        Position placePosition = null;
        placePosition = new Position(xPosition, yPosition, direction);
        if (placePosition == null){
            throw new InvalidPositionException("error: exceed bourndary");
        }

        Robot robot = new Robot(placePosition);

        return robot;
    }

    public Position move(Position p) throws Exception {
        if(p == null || !p.checkValidDirection(p.getDirection())){
            throw new InvalidDirectionException("error: invalid direction");
        }else {
            switch(p.getDirection()){
                /*
                    Update the robot coordinate.
                    But also ensure other properities do not change.
                 */
                case NORTH:
                    if (p.checkValidYCoordinate(p.getyPosition() + 1)){
                        p.setxPosition(p.getxPosition());
                        p.setyPosition(p.getyPosition()+1);
                        p.setDirection(p.getDirection());
                        break;
                    } else{
                        throw new InvalidPositionException("Robot cannot move due to y axis larger than " + Table.MAX_Y);
                    }
                case SOUTH:
                    if (p.checkValidYCoordinate(p.getyPosition() - 1)){
                        p.setxPosition(p.getxPosition());
                        p.setyPosition(p.getyPosition() - 1);
                        p.setDirection(p.getDirection());
                        break;
                    } else{
                        throw new InvalidPositionException("Robot cannot move due to y axis smaller than " + Table.MIN_Y);
                    }
                case EAST:
                    if (p.checkValidXCoordinate(p.getxPosition() + 1)){
                        p.setxPosition(p.getxPosition() + 1);
                        p.setyPosition(p.getyPosition());
                        p.setDirection(p.getDirection());
                        break;
                    } else{
                        throw new InvalidPositionException("Robot cannot move due to x axis larger than " + Table.MAX_X);
                    }
                case WEST:
                    if (p.checkValidXCoordinate(p.getxPosition() - 1)){
                        p.setxPosition(p.getxPosition() - 1);
                        p.setyPosition(p.getyPosition());
                        p.setDirection(p.getDirection());
                        break;
                    } else{
                        throw new InvalidPositionException("Robot cannot move due to x axis smaller than "+ Table.MIN_X);
                    }
            }
        }

        return p;

    }

    public Position leftCommand(Position p) throws Exception{
        Position newPosition = null;
        if(p.getDirection() == null || !p.checkValidDirection(p.getDirection())){
            throw new InvalidDirectionException("error: invalid direction");
        }else {
            switch(p.getDirection()){
                case NORTH:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.WEST);
                    break;
                case SOUTH:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.EAST);
                    break;
                case EAST:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.NORTH);
                    break;
                case WEST:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.SOUTH);
                    break;
            }
        }

        newPosition = new Position(p.getxPosition(), p.getyPosition(), p.getDirection());

        return newPosition;
    }

    public Position rightCommand(Position p) throws Exception {
        Position newPosition = null;
        if(p.getDirection() == null || !p.checkValidDirection(p.getDirection())){
            throw new InvalidDirectionException("error: invalid direction");
        }else {
            switch (p.getDirection()) {
                case NORTH:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.EAST);
                    break;
                case SOUTH:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.WEST);
                    break;
                case EAST:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.SOUTH);
                    break;
                case WEST:
                    p.setxPosition(p.getxPosition());
                    p.setyPosition(p.getyPosition());
                    p.setDirection(Direction.NORTH);
                    break;
            }
        }

        newPosition = new Position(p.getxPosition(), p.getyPosition(), p.getDirection());

        return newPosition;
    }

    public String reportCommand(Robot robot){
        String output = robot.getPosition().getxPosition() + " " +
                        robot.getPosition().getyPosition() + " " +
                        robot.getPosition().getDirection();

        return output;
    }
}
