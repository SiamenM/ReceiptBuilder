package maskalenchyk.receipt_builder.service;

import maskalenchyk.receipt_builder.commands.CommandException;
import maskalenchyk.receipt_builder.entity.Receipt;
import maskalenchyk.receipt_builder.entity.ReceiptItem;

import java.util.List;

public interface ReceiptBuilder {

    Receipt buildReceipt(List<String> items) throws CommandException;
}
