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
        Position newPosition = p.updateCoordinate();
        return newPosition;

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
