package maskalenchyk.receipt_builder.commands;

import java.util.List;

public interface Command {

    String execute(List<String> params) throws CommandException;

    String getCommandIdentifier();
}


