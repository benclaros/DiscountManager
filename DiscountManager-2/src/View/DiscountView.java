package view;

import model.Product;
import model.discount.DiscountManager;

public class DiscountView {
    public void showDiscountedPrice(Product product) {
        double price = DiscountManager.getInstance().applyDiscount(product);
        System.out.println(product.getName() + " -> $" + price);
    }
}
