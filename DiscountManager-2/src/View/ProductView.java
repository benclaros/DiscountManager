package view;

import model.Product;
import java.util.List;

public class ProductView {
    public void showProducts(List<Product> products) {
        System.out.println("=== Lista de productos ===");
        for (Product p : products) { System.out.println(p); }
    }
}
