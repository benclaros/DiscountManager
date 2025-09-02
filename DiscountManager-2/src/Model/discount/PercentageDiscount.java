package model.discount;

import model.Product;

public class PercentageDiscount extends Decorator {
    private double percentage;

    public PercentageDiscount(Component component, double percentage) {
        super(component);
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(Product product) {
        double basePrice = component.applyDiscount(product);
        return basePrice - (basePrice * percentage / 100);
    }
}
