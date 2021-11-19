package maskalenchyk.receipt_builder.service;

import maskalenchyk.receipt_builder.dal.DiscountCardContainer;
import maskalenchyk.receipt_builder.dal.DiscountCardContainerImpl;
import maskalenchyk.receipt_builder.dal.ProductContainer;
import maskalenchyk.receipt_builder.dal.ProductContainerImpl;
import maskalenchyk.receipt_builder.entity.Receipt;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReceiptBuilderImplTest {

    private ProductContainer productContainer = new ProductContainerImpl();
    private DiscountCardContainer discountCardContainer = new DiscountCardContainerImpl();
    private ReceiptBuilder receiptBuilder = new ReceiptBuilderImpl(productContainer,discountCardContainer);


    @Test
    public void buildReceiptShouldBeEquals() {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(100);
        receipt.setItems(Arrays.asList());
    }
}