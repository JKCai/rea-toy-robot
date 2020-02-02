public abstract class Command {
    public Robot place(Integer xPosition, Integer yPosition, Direction direction) throws Exception {
        return null;
    }

    public Position move(Position p) throws Exception{
        return null;
    }

    public Position leftCommand(Position p) throws Exception{
        return null;
    }

    public Position rightCommand(Position p) throws Exception{
        return null;
    }

    public String reportCommand(Robot robot){
        return null;
    }
}
