package discountmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instancia única del DiscountManager
        DiscountManager gestor = DiscountManager.getInstance();

        // Precios base
        double precioPantalon = 30000; // $30.000
        double precioPolera   = 15000; // $15.000

        // Descuentos predefinidos
        double descuentoPantalon = 15; // 15%
        double descuentoPolera   = 10; // 10%

        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n=== SISTEMA DE PEDIDOS TIENDA DE ROPA ===");
            System.out.println("1. Comprar Pantalón");
            System.out.println("2. Comprar Polera");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    double precioFinalPantalon = gestor.aplicarDescuento(precioPantalon, descuentoPantalon);
                    System.out.println("\nPrecio del pantalón: $" + precioPantalon);
                    System.out.println("Descuento aplicado: " + descuentoPantalon + "%");
                    System.out.println("Precio final: $" + precioFinalPantalon);
                    break;

                case 2:
                    double precioFinalPolera = gestor.aplicarDescuento(precioPolera, descuentoPolera);
                    System.out.println("\nPrecio de la polera: $" + precioPolera);
                    System.out.println("Descuento aplicado: " + descuentoPolera + "%");
                    System.out.println("Precio final: $" + precioFinalPolera);
                    break;

                case 3:
                    System.out.println("\nGracias por usar el sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
}
