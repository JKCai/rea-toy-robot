public class Command {

    public Command(){

    }

    public Robot place(Integer xPosition, Integer yPosition, Direction direction){
        Position placePosition = null;
        try {
            placePosition = new Position(xPosition, yPosition, direction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Robot robot = new Robot(placePosition);

        return robot;
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

        try {
            newPosition = new Position(p.getxPosition(), p.getyPosition(), p.getDirection());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        try {
            newPosition = new Position(p.getxPosition(), p.getyPosition(), p.getDirection());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newPosition;
    }
}
