package command;

import model.discount.Component;
import model.discount.DiscountManager;
import model.discount.PercentageDiscount;
import model.discount.ProductComponent;

public class ApplyPercentageDiscountCommand implements Command {
    private final double percentage;

    public ApplyPercentageDiscountCommand(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public void execute() {
        // Encadena el descuento sobre el componente base (o el actual, si prefieres)
        Component base = new ProductComponent();
        Component decorated = new PercentageDiscount(base, percentage);
        DiscountManager.getInstance().setDiscountComponent(decorated);
        System.out.println("Descuento aplicado: " + percentage + "% a todos los productos.");
    }
}
