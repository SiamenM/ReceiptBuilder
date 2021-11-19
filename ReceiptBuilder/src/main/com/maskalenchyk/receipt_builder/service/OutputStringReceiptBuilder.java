package maskalenchyk.receipt_builder.service;

import maskalenchyk.receipt_builder.entity.Receipt;

public interface OutputStringReceiptBuilder {

    String buildOutputString(Receipt receipt);
}
