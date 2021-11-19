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

import java.util.Scanner;

public class Application {

    private static ProductContainer productContainer = new ProductContainerImpl();
    private static DiscountCardContainer cardContainer = new DiscountCardContainerImpl();
    private static ReceiptBuilder receiptBuilder = new ReceiptBuilderImpl(productContainer, cardContainer);
    private static OutputStringReceiptBuilder outputStringReceiptBuilder = new OutputStringReceiptBuilderImpl();
    private static InputValidator inputValidator = new InputValidatorImpl();
    private static BuildReceiptCommand buildReceiptCommand = new BuildReceiptCommand(inputValidator, receiptBuilder, outputStringReceiptBuilder);

    //example input 3-1 2-5 5-1 card-1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter data:");
        String input = scanner.nextLine();
        try {
            System.out.println(buildReceiptCommand.execute(input));
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
