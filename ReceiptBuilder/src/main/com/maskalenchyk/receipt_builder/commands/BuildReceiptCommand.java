package maskalenchyk.receipt_builder.commands;

import maskalenchyk.receipt_builder.entity.Receipt;
import maskalenchyk.receipt_builder.service.OutputStringReceiptBuilder;
import maskalenchyk.receipt_builder.service.ReceiptBuilder;

import java.util.List;

public class BuildReceiptCommand implements Command {

    private InputValidator inputValidator;
    private ReceiptBuilder receiptBuilder;
    private OutputStringReceiptBuilder outputStringReceiptBuilder;

    public BuildReceiptCommand(InputValidator inputValidator, ReceiptBuilder receiptBuilder, OutputStringReceiptBuilder outputStringReceiptBuilder) {
        this.inputValidator = inputValidator;
        this.receiptBuilder = receiptBuilder;
        this.outputStringReceiptBuilder = outputStringReceiptBuilder;
    }

    @Override
    public String execute(List<String> params) throws CommandException {
        if (inputValidator.validateInput(params)) {
            Receipt receipt = receiptBuilder.buildReceipt(params);
            return outputStringReceiptBuilder.buildOutputString(receipt);
        } else {
            throw new CommandException("Invalid input");
        }
    }

    @Override
    public String getCommandIdentifier() {
        return null;
    }
}
