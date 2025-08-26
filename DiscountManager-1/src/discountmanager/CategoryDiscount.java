package discountmanager;

// Decorador de 20% en categoría específica
public class CategoryDiscount extends Decorator {
    private String category;

    public CategoryDiscount(Component component, String category) {
        super(component);
        this.category = category;
    }

    @Override
    public double getPrice() {
        // Si el nombre del producto contiene la categoría, aplica 20% descuento
        if (super.getName().toLowerCase().contains(category.toLowerCase())) {
            return super.getPrice() * 0.8;
        }
        return super.getPrice();
    }
}
