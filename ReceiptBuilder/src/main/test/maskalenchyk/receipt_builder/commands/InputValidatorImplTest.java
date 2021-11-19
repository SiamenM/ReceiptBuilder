package maskalenchyk.receipt_builder.commands;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputValidatorImplTest {

    private List<String> validInput1 = Arrays.asList("3-1", "2-5", "5-1", "card-123");
    private List<String> validInput2 = Arrays.asList("32-31", "23-3", "53-13", "CARD-123456");
    private List<String> validInput3 = Arrays.asList("32-31", "23-3", "53-13", "1-3");
    private List<String> invalidInput1 = Arrays.asList("h3-1", "2-5", "5-1", "card-card");
    private List<String> invalidInput2 = Arrays.asList("3-1", "25", "5-1", "card-123");
    private List<String> invalidInput3 = Arrays.asList("3-1", "25", "5-1", "card123");
    private List<String> invalidInput4 = Arrays.asList("3-1", "25", "5$1", "card123");
    private List<String> invalidInput5 = Collections.singletonList("");
    private List<String> invalidInput6 = null;

    private InputValidator inputValidator = new InputValidatorImpl();

    @Test
    public void validateInputShouldBeTrue() {
        Assert.assertTrue(inputValidator.validateInput(validInput1));
        Assert.assertTrue(inputValidator.validateInput(validInput2));
        Assert.assertTrue(inputValidator.validateInput(validInput3));
    }

    @Test
    public void validateInputShouldBeFalse() {
        Assert.assertFalse(inputValidator.validateInput(invalidInput1));
        Assert.assertFalse(inputValidator.validateInput(invalidInput2));
        Assert.assertFalse(inputValidator.validateInput(invalidInput3));
        Assert.assertFalse(inputValidator.validateInput(invalidInput4));
        Assert.assertFalse(inputValidator.validateInput(invalidInput5));
        Assert.assertFalse(inputValidator.validateInput(invalidInput6));
    }
}