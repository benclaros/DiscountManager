package command;

import model.discount.CategoryDiscount;
import model.discount.Component;
import model.discount.DiscountManager;

public class ApplyCategoryDiscountCommand implements Command {
    private final String category;
    private final double percentage;

    public ApplyCategoryDiscountCommand(String category, double percentage) {
        this.category = category;
        this.percentage = percentage;
    }

    @Override
    public void execute() {
        // Encadena sobre el componente actual para que el descuento sea acumulable
        Component current = DiscountManager.getInstanceComponent();
        if (current == null) {
            // helper: si no existe, partimos desde el que ya tenga DiscountManager internamente
            current = DiscountManager.getInstanceDefaultComponent();
        }
        Component decorated = new CategoryDiscount(current, category, percentage);
        DiscountManager.getInstance().setDiscountComponent(decorated);
        System.out.println("Descuento por categoría aplicado: " + percentage + "% en " + category + ".");
    }
}
