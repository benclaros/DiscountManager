package discountmanager;

public class DiscountManager {
    // Instancia única
    private static DiscountManager instance;

    // Constructor privado
    private DiscountManager() {
        System.out.println("Gestor de Descuentos inicializado.");
    }

    // Método estático para obtener la instancia única
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Método para aplicar un descuento
    public double aplicarDescuento(double precio, double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        double descuento = precio * (porcentaje / 100);
        return precio - descuento;
    }
}
