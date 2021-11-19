package maskalenchyk.receipt_builder.service;

import maskalenchyk.receipt_builder.application.ApplicationConstants;
import maskalenchyk.receipt_builder.entity.DiscountCard;
import maskalenchyk.receipt_builder.entity.Receipt;
import maskalenchyk.receipt_builder.entity.ReceiptItem;

import java.math.BigDecimal;
import java.util.List;

public class OutputStringReceiptBuilderImpl implements OutputStringReceiptBuilder {

    private final String receiptTitle = "CASH RECEIPT";
    private final String quantityColumnName = "QTY";
    private final String productColumnName = "Description";
    private final String priceColumnName = "Price";
    private final String totalPriceColumnName = "Total";

    @Override
    public String buildOutputString(Receipt receipt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t" + "\t" + receiptTitle + "\n");
        stringBuilder.append("\t" + "\t" + ApplicationConstants.shopName + "\n");
        stringBuilder.append("\t" + "\t" + ApplicationConstants.shopAddress + "\n");
        stringBuilder.append("\t" + "\t" + ApplicationConstants.shopTelephone + "\n");
        stringBuilder.append("============================\n");
        stringBuilder.append(quantityColumnName + "\t" + productColumnName + "\t" + priceColumnName + "\t" + totalPriceColumnName);
        stringBuilder.append("\n");
        for (ReceiptItem item : receipt.getItems()) {
            String itemString = getReceiptItemFormattedString(item);
            stringBuilder.append(itemString);
        }
        BigDecimal totalPriceWithoutDiscount = getTotalPriceFromReceipt(receipt);
        Integer discount = getDiscountValue(receipt);
        BigDecimal totalPrice = totalPriceWithoutDiscount.subtract(totalPriceWithoutDiscount.multiply(new BigDecimal(discount)).divide(new BigDecimal(100)));
        stringBuilder.append("============================\n");
        stringBuilder.append("Taxable TOT.");
        stringBuilder.append("\t\t\t$");
        stringBuilder.append(totalPriceWithoutDiscount.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Discount");
        stringBuilder.append("\t\t\t\t$");
        stringBuilder.append(discount.toString());
        stringBuilder.append("\n");
        stringBuilder.append("TOTAL");
        stringBuilder.append("\t\t\t\t\t$");
        stringBuilder.append(totalPrice.toString());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String getReceiptItemFormattedString(ReceiptItem item) {
        BigDecimal totalItemPrice = item.getProduct().getProductPrice().multiply(new BigDecimal(item.getProductAmount()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item.getProductAmount());
        stringBuilder.append("\t");
        stringBuilder.append(item.getProduct().getProductName());
        stringBuilder.append("\t");
        stringBuilder.append("$");
        stringBuilder.append(item.getProduct().getProductPrice().toString());
        stringBuilder.append("\t\t");
        stringBuilder.append("$");
        stringBuilder.append(totalItemPrice.toString());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private Integer getDiscountValue(Receipt receipt) {
        DiscountCard discountCard = receipt.getDiscountCard();
        if (discountCard == null) {
            return 0;
        } else {
            return discountCard.getDiscount();
        }

    }

    private BigDecimal getTotalPriceFromReceipt(Receipt receipt) {
        List<ReceiptItem> receiptItemList = receipt.getItems();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ReceiptItem receiptItem : receiptItemList) {
            totalPrice = totalPrice.add(receiptItem.getProduct().getProductPrice());
        }
        return totalPrice;
    }
}
