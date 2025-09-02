package controller;

import model.Product;
import model.discount.DiscountManager;

public class DiscountController {
    private DiscountManager discountManager;

    public DiscountController() { discountManager = DiscountManager.getInstance(); }

    public double applyDiscount(Product product) { return discountManager.applyDiscount(product); }
}
