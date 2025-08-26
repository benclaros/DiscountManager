package discountmanager;

public class DiscountManager {
    // Instancia única
    private static final DiscountManager instance = new DiscountManager();

    private DiscountManager() {
        System.out.println("Gestor de Descuentos inicializado.");
    }

    public static DiscountManager getInstance() {
        return instance;
    }

    // Método genérico que aplica un descuento mediante un Component
    public double applyDiscount(Component product) {
        return product.getPrice();
    }
}
