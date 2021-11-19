package maskalenchyk.receipt_builder.dal;

import maskalenchyk.receipt_builder.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductContainerImpl implements ProductContainer {

    private Map<Integer, Product> productStorage;

    public ProductContainerImpl() {
        this.productStorage = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            productStorage.put(i, new Product(i, "Product1", new BigDecimal(10 * i)));
        }
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productStorage.values());
    }

    @Override
    public void save(Product product) throws ContainerException {
        if (!this.productStorage.containsKey(product.getProductId())) {
            this.productStorage.put(product.getProductId(), product);
        }
        throw new ContainerException("Product with id " + product.getProductId() + " already exists");
    }

    @Override
    public void update(Integer id, Product product) throws ContainerException {
        if (this.productStorage.containsKey(id)) {
            this.productStorage.put(id, product);
        } else {
            throw new ContainerException("Product with id " + id + " doesn't exists");
        }
    }

    @Override
    public Product get(Integer id) throws ContainerException {
        if (this.productStorage.containsKey(id)) {
            return this.productStorage.get(id);
        } else {
            throw new ContainerException("Product with id " + id + " doesn't exists");
        }
    }

    @Override
    public void delete(Integer id) throws ContainerException {
        if (this.productStorage.containsKey(id)) {
            this.productStorage.remove(id);
        } else {
            throw new ContainerException("Product with id " + id + " doesn't exists");
        }
    }
}
