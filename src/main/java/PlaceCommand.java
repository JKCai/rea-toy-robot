public class PlaceCommand extends Command{

    @Override
    public Robot place(Integer xPosition, Integer yPosition, Direction direction) throws Exception {
        Position placePosition = null;
        placePosition = new Position(xPosition, yPosition, direction);
        if (placePosition == null){
            throw new InvalidPositionException("error: exceed bourndary");
        }

        Robot robot = new Robot(placePosition);

        return robot;
    }
}
