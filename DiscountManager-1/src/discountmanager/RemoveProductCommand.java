package discountmanager;

import java.util.List;

public class RemoveProductCommand implements Command {
    private List<Component> carrito;
    private Component producto;

    public RemoveProductCommand(List<Component> carrito, Component producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        if (carrito.remove(producto)) {
            System.out.println(producto.getName() + " eliminado del carrito.");
        } else {
            System.out.println(producto.getName() + " no estaba en el carrito.");
        }
    }
}
