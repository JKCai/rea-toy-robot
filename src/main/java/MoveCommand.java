public class MoveCommand extends Command {
    @Override
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
}
