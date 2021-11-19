package maskalenchyk.receipt_builder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Receipt {
    private Integer receiptId;
    private DiscountCard discountCard;
    private List<ReceiptItem> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public Receipt(Integer receiptId, DiscountCard discountCard, List<ReceiptItem> items) {
        this.receiptId = receiptId;
        this.discountCard = discountCard;
        this.items = items;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(receiptId, receipt.receiptId) &&
                Objects.equals(items, receipt.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, items);
    }


    public void addReceiptItem(ReceiptItem receiptItem) {
        this.items.add(receiptItem);
    }

}
