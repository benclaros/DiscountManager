package controller;

import model.Product;
import java.util.List;

public class ProductController {
    private List<Product> products;

    public ProductController(List<Product> products) { this.products = products; }
    public List<Product> getProducts() { return products; }
}
