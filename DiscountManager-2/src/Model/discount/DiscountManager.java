package model.discount;

import model.Product;

public class DiscountManager {
    private static DiscountManager instance;
    private Component discountComponent;

    private DiscountManager() {
        discountComponent = new ProductComponent(); // Componente base
    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // NUEVO: exponer el componente actual (para encadenar decoradores)
    public static Component getInstanceComponent() {
        return getInstance().discountComponent;
    }

    // NUEVO: por si quieres el base por defecto explícitamente
    public static Component getInstanceDefaultComponent() {
        return new ProductComponent();
    }

    public void setDiscountComponent(Component component) {
        this.discountComponent = component;
    }

    public double applyDiscount(Product product) {
        return discountComponent.applyDiscount(product);
    }
}
