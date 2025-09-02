package model.discount;

import model.Product;

public class CategoryDiscount extends Decorator {
    private String category;
    private double percentage;

    public CategoryDiscount(Component component, String category, double percentage) {
        super(component);
        this.category = category;
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(Product product) {
        double basePrice = component.applyDiscount(product);
        if (product.getCategory().equalsIgnoreCase(category)) {
            return basePrice - (basePrice * percentage / 100);
        }
        return basePrice;
    }
}
