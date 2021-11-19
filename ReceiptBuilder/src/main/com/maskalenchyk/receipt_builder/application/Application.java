package maskalenchyk.receipt_builder.application;

import maskalenchyk.receipt_builder.commands.BuildReceiptCommand;
import maskalenchyk.receipt_builder.commands.CommandException;
import maskalenchyk.receipt_builder.commands.InputValidator;
import maskalenchyk.receipt_builder.commands.InputValidatorImpl;
import maskalenchyk.receipt_builder.dal.DiscountCardContainer;
import maskalenchyk.receipt_builder.dal.DiscountCardContainerImpl;
import maskalenchyk.receipt_builder.dal.ProductContainer;
import maskalenchyk.receipt_builder.dal.ProductContainerImpl;
import maskalenchyk.receipt_builder.service.OutputStringReceiptBuilder;
import maskalenchyk.receipt_builder.service.OutputStringReceiptBuilderImpl;
import maskalenchyk.receipt_builder.service.ReceiptBuilder;
import maskalenchyk.receipt_builder.service.ReceiptBuilderImpl;

import java.util.Arrays;

public class Application {

    private static ProductContainer productContainer = new ProductContainerImpl();
    private static DiscountCardContainer cardContainer = new DiscountCardContainerImpl();
    private static ReceiptBuilder receiptBuilder = new ReceiptBuilderImpl(productContainer, cardContainer);
    private static OutputStringReceiptBuilder outputStringReceiptBuilder = new OutputStringReceiptBuilderImpl();
    private static InputValidator inputValidator = new InputValidatorImpl();
    private static BuildReceiptCommand buildReceiptCommand = new BuildReceiptCommand(inputValidator, receiptBuilder, outputStringReceiptBuilder);


    public static void main(String[] args) throws CommandException {
        System.out.println("Please enter data:");
        String result = buildReceiptCommand.execute(Arrays.asList(args));
        System.out.println(result);
    }


}
