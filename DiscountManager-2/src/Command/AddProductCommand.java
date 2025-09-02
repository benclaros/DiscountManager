package command;

import model.Order;
import model.Product;

public class AddProductCommand implements Command {
    private Order order;
    private Product product;

    public AddProductCommand(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @Override
    public void execute() { order.addProduct(product); }
}
