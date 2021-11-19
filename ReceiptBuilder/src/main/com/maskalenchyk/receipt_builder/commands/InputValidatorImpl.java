package maskalenchyk.receipt_builder.commands;

import java.util.List;

public class InputValidatorImpl implements InputValidator {

    @Override
    public Boolean validateInput(List<String> inputElements) {
        if (inputElements == null) {
            return false;
        }
        return lengthValidate(inputElements)
                && elementsValidate(inputElements)
                && lastElementValidate(inputElements.get(inputElements.size() - 1));
    }

    private Boolean lengthValidate(List<String> inputElements) {
        return inputElements.size() > 0;
    }

    private Boolean elementsValidate(List<String> inputElements) {
        for (int i = 0; i < inputElements.size() - 1; i++) {
            String inputElement = inputElements.get(i);
            if (!(inputElement.length() >= 3 && Character.isDigit(inputElement.charAt(0))
                    && Character.isDigit(inputElement.charAt(inputElement.length() - 1))
                    && inputElement.contains("-"))) {
                return false;
            }
        }
        return true;
    }

    private Boolean lastElementValidate(String lastElement) {
        boolean firstCondition = lastElement.length() >= 3
                && Character.isDigit(lastElement.charAt(lastElement.length() - 1))
                && lastElement.contains("-");
        return lastElement.length() >= 6 && lastElement.toLowerCase().startsWith("card")
                && Character.isDigit(lastElement.charAt(lastElement.length() - 1)) || firstCondition;
    }
}
