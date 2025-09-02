import model.*;
import model.discount.*;
import controller.*;
import view.*;
import command.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Productos
        Product p1 = new Product(1, "Polera Roja", "Polera", 20.0);
        Product p2 = new Product(2, "Jeans Azul", "Pantalón", 50.0);
        Product p3 = new Product(3, "Chaqueta Negra", "Chaqueta", 100.0);

        List<Product> productList = Arrays.asList(p1, p2, p3);

        // Controladores y vistas
        ProductController productController = new ProductController(productList);
        ProductView productView = new ProductView();
        Order order = new Order(1);
        CartControler cartController = new CartControler();
        CartView cartView = new CartView();
        DiscountManager discountManager = DiscountManager.getInstance();
        DiscountView discountView = new DiscountView();

        // Descuento inicial 10%
        Component discount10 = new PercentageDiscount(new ProductComponent(), 10);
        discountManager.setDiscountComponent(discount10);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Eliminar producto del carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Aplicar descuentos");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");
            int option = sc.nextInt(); sc.nextLine();

            switch(option) {
                case 1:
                    productView.showProducts(productController.getProducts());
                    break;
                case 2:
                    System.out.print("ID del producto a agregar: ");
                    int addId = sc.nextInt(); sc.nextLine();
                    Product addProduct = productList.stream().filter(p -> p.getId() == addId).findFirst().orElse(null);
                    if (addProduct != null) {
                        Command addCmd = new AddProductCommand(order, addProduct);
                        cartController.addProductToCart(addCmd);
                        System.out.println("Producto agregado.");
                    } else System.out.println("Producto no encontrado.");
                    break;
                case 3:
                    System.out.print("ID del producto a eliminar: ");
                    int removeId = sc.nextInt(); sc.nextLine();
                    Product removeProduct = order.getProducts().stream().filter(p -> p.getId() == removeId).findFirst().orElse(null);
                    if (removeProduct != null) {
                        Command removeCmd = new RemoveProductCommand(order, removeProduct);
                        cartController.removeProductFromCart(removeCmd);
                        System.out.println("Producto eliminado.");
                    } else System.out.println("Producto no encontrado en el carrito.");
                    break;
                case 4:
                    cartView.showCart(order);
                    break;
                case 5:
                System.out.println("=== Aplicar descuentos ===");
                System.out.println("1) 10% a todos");
                System.out.println("2) 20% a categoría 'Pantalón'");
                System.out.println("3) Personalizado (porcentaje a todos)");
                System.out.print("Elija opción: ");
                int dop = sc.nextInt(); sc.nextLine();

                Command discountCmd = null;
                switch (dop) {
                    case 1:
                        discountCmd = new ApplyPercentageDiscountCommand(10);
                        break;
                    case 2:
                        discountCmd = new ApplyCategoryDiscountCommand("Pantalón", 20);
                        break;
                    case 3:
                        System.out.print("Porcentaje: ");
                        double pct = sc.nextDouble(); sc.nextLine();
                        discountCmd = new ApplyPercentageDiscountCommand(pct);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
                if (discountCmd != null) {
                    discountCmd.execute(); // Aplica el descuento vía Command
                    System.out.println("--- Precios con descuento ---");
                    for (Product p : productList) {
                        discountView.showDiscountedPrice(p);
                    }
                }
                break;

                case 6:
                    exit = true;
                    System.out.println("Gracias por su visita.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
