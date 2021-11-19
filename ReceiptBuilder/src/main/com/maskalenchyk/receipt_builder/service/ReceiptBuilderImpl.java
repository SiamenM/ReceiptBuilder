package maskalenchyk.receipt_builder.service;

import maskalenchyk.receipt_builder.commands.CommandException;
import maskalenchyk.receipt_builder.dal.ContainerException;
import maskalenchyk.receipt_builder.dal.DiscountCardContainer;
import maskalenchyk.receipt_builder.dal.ProductContainer;
import maskalenchyk.receipt_builder.entity.DiscountCard;
import maskalenchyk.receipt_builder.entity.Product;
import maskalenchyk.receipt_builder.entity.Receipt;
import maskalenchyk.receipt_builder.entity.ReceiptItem;

import java.util.Arrays;
import java.util.List;

public class ReceiptBuilderImpl implements ReceiptBuilder {

    private ProductContainer productContainer;
    private DiscountCardContainer discountCardContainer;

    public ReceiptBuilderImpl(ProductContainer productContainer, DiscountCardContainer discountCardContainer) {
        this.productContainer = productContainer;
        this.discountCardContainer = discountCardContainer;
    }

    @Override
    public Receipt buildReceipt(List<String> items) throws CommandException {
        DiscountCard discountCard = null;
        if (items.get(items.size() - 1).toLowerCase().startsWith("card")) {
            discountCard = getCardFromInput(items.get(items.size() - 1));
        }
        Receipt receipt = getReceiptItemsFromInput(items);
        if (discountCard!=null){
            receipt.setDiscountCard(discountCard);
        }
        return receipt;
    }

    private Receipt getReceiptItemsFromInput(List<String> items) throws CommandException {
        Receipt receipt = new Receipt();
        try {
            int i = 0;
            while (Character.isDigit(items.get(i).charAt(0))) {
                List<String> receiptItemData = Arrays.asList(items.get(i).split("-"));
                Integer idProduct = Integer.parseInt(receiptItemData.get(0));
                Product product = productContainer.get(idProduct);
                Integer productAmount = Integer.parseInt(receiptItemData.get(1));
                ReceiptItem receiptItem = new ReceiptItem();
                receiptItem.setProduct(product);
                receiptItem.setProductAmount(productAmount);
                receipt.addReceiptItem(receiptItem);
                i++;
            }
        } catch (ContainerException e) {
            throw new CommandException(e.getMessage(), e);
        }
        return receipt;
    }

    private DiscountCard getCardFromInput(String inputCard) throws CommandException {
        try {
            List<String> inputCardData = Arrays.asList(inputCard.split("-"));
            Integer cardId = Integer.parseInt(inputCardData.get(1));
            return discountCardContainer.get(cardId);
        } catch (ContainerException e) {
            throw new CommandException(e.getMessage(), e);
        }
    }

}
