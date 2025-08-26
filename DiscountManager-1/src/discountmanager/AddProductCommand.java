package discountmanager;

import java.util.List;

public class AddProductCommand implements Command {
    private List<Component> carrito;
    private Component producto;

    public AddProductCommand(List<Component> carrito, Component producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        carrito.add(producto);
        System.out.println(producto.getName() + " agregado al carrito. Precio final: $" + producto.getPrice());
    }
}
