package view;

import model.Order;

public class CartView {
    public void showCart(Order order) {
        System.out.println("=== Carrito de compras ===");
        if (order.getProducts().isEmpty()) {
            System.out.println("Carrito vacío.");
        } else {
            for (var p : order.getProducts()) { System.out.println(p); }
        }
    }
}
