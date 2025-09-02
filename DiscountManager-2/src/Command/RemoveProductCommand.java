package command;

import model.Order;
import model.Product;

public class RemoveProductCommand implements Command {
    private Order order;
    private Product product;

    public RemoveProductCommand(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @Override
    public void execute() { order.removeProduct(product); }
}
