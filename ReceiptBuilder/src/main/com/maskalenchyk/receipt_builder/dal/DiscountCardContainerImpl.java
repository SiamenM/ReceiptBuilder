package maskalenchyk.receipt_builder.dal;

import maskalenchyk.receipt_builder.entity.DiscountCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiscountCardContainerImpl implements DiscountCardContainer {

    private HashMap<Integer, DiscountCard> discountCardContainer;

    public DiscountCardContainerImpl() {
        this.discountCardContainer = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            discountCardContainer.put(i, new DiscountCard(i, "Card" + 1, 10 + i));
        }
    }

    @Override
    public List<DiscountCard> findAll() {
        return new ArrayList<>(discountCardContainer.values());
    }

    @Override
    public void save(DiscountCard discountCard) throws ContainerException {
        if (!this.discountCardContainer.containsKey(discountCard.getCardId())) {
            this.discountCardContainer.put(discountCard.getCardId(), discountCard);
        }
        throw new ContainerException("Discount card with id " + discountCard.getCardId() + " already exists");
    }

    @Override
    public void update(Integer id, DiscountCard discountCard) throws ContainerException {
        if (this.discountCardContainer.containsKey(id)) {
            this.discountCardContainer.put(id, discountCard);
        } else {
            throw new ContainerException("Discount card with id " + id + " doesn't exists");
        }
    }

    @Override
    public DiscountCard get(Integer id) throws ContainerException {
        if (this.discountCardContainer.containsKey(id)) {
            return this.discountCardContainer.get(id);
        } else {
            throw new ContainerException("Discount card with id " + id + " doesn't exists");
        }
    }

    @Override
    public void delete(Integer id) throws ContainerException {
        if (this.discountCardContainer.containsKey(id)) {
            this.discountCardContainer.remove(id);
        } else {
            throw new ContainerException("Discount card with id " + id + " doesn't exists");
        }
    }
}
