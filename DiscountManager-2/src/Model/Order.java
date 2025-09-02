package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products = new ArrayList<>();

    public Order(int id) { this.id = id; }

    public void addProduct(Product product) { products.add(product); }
    public void removeProduct(Product product) { products.remove(product); }
    public List<Product> getProducts() { return products; }
}
