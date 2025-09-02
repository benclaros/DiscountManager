package model.discount;

import model.Product;

public class ProductComponent implements Component {
    @Override
    public double applyDiscount(Product product) {
        return product.getPrice(); // Precio base
    }
}
