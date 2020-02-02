public class CommandFactory {
    public static Command getCommand(String command){
        String inputCommand;
        String[] inputContent = new String[0];
        if (command == null){
            return null;
        }else{
            Integer commandIndex = command.indexOf(" ",0);

            if (commandIndex != -1){
                inputCommand = command.substring(0, commandIndex);
                inputContent = command.substring(commandIndex+1).split(",");
            }else{
                inputCommand = command;
            }
        }

        if (inputCommand.equalsIgnoreCase("PLACE")){
            return new PlaceCommand(inputContent);
        }else if(inputCommand.equalsIgnoreCase("MOVE")){
            return new MoveCommand();
        }else if (inputCommand.equalsIgnoreCase("LEFT")){
            return new LeftCommand();
        }else if (inputCommand.equalsIgnoreCase("RIGHT")){
            return new RightCommand();
        }else if (inputCommand.equalsIgnoreCase("REPORT")){
            return new ReportCommand();
        }else{
            new InvalidCommandException("Invalid command");
        }
        
        return null;
    }
}
