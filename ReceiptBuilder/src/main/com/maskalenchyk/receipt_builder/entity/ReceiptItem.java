package maskalenchyk.receipt_builder.entity;

public class ReceiptItem {
    private Product product;
    private Integer productAmount;

    public ReceiptItem() {
    }

    public ReceiptItem(Product product, Integer productAmount) {
        this.product = product;
        this.productAmount = productAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
