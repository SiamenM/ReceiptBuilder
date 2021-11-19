package maskalenchyk.receipt_builder.commands;

import java.util.List;

public interface InputValidator {

    Boolean validateInput(List<String> inputElements);
}
