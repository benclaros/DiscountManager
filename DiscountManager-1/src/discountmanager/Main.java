package discountmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Component> carrito = new ArrayList<>();
        DiscountManager gestor = DiscountManager.getInstance();

        int opcion;
        do {
            System.out.println("\n=== TIENDA DE ROPA ===");
            System.out.println("1. Comprar Pantalón (con 10% descuento)");
            System.out.println("2. Comprar Polera (con 20% descuento por categoría)");
            System.out.println("3. Eliminar producto del carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Component pantalon = new Product("Pantalón", 30000);
                    Component pantalonConDescuento = new TenPercentDiscount(pantalon);
                    new AddProductCommand(carrito, pantalonConDescuento).ejecutar();
                    break;

                case 2:
                    Component polera = new Product("Polera categoría deportiva", 15000);
                    Component poleraConDescuento = new CategoryDiscount(polera, "deportiva");
                    new AddProductCommand(carrito, poleraConDescuento).ejecutar();
                    break;

                case 3:
                    if (!carrito.isEmpty()) {
                        Component ultimo = carrito.get(carrito.size() - 1);
                        new RemoveProductCommand(carrito, ultimo).ejecutar();
                    } else {
                        System.out.println("El carrito está vacío.");
                    }
                    break;

                case 4:
                    double total = 0;
                    System.out.println("\n--- Carrito ---");
                    for (Component p : carrito) {
                        System.out.println(p.getName() + " - $" + p.getPrice());
                        total += p.getPrice();
                    }
                    System.out.println("TOTAL: $" + total);
                    break;

                case 5:
                    System.out.println("Gracias por su compra. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}
