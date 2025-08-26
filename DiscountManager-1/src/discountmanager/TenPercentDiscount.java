package discountmanager;

// Decorador de 10% en todos los productos
public class TenPercentDiscount extends Decorator {

    public TenPercentDiscount(Component component) {
        super(component);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.9; // aplica 10% de descuento
    }
}
