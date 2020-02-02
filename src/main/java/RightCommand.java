public class RightCommand extends Command{

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
}
