package maskalenchyk.receipt_builder.commands;

public interface CommandFactory {

    Command getCommand(String commandName);
}
