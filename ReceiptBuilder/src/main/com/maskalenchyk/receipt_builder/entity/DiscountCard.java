package maskalenchyk.receipt_builder.entity;

import java.util.Objects;

public class DiscountCard {
    private Integer cardId;
    private String cardName;
    private Integer discount;

    public DiscountCard(Integer cardId, String cardName, Integer discount) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.discount = discount;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(cardName, that.cardName) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardName, discount);
    }
}
