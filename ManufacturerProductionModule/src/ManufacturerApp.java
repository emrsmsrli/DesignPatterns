import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.manufacturer.items.Component;
import manufacturerproduction.manufacturer.items.Product;

import java.util.List;

public class ManufacturerApp {

    public static void main(String[] args) {
        Component part = Manufacturer.newPart("part1");
        Component part2 = Manufacturer.newPart("part2");

        Component component1_1 = Manufacturer.newCompositeComponent("component1", null);
        Component component1_2 = Manufacturer.newCompositeComponent("component1", null);
        Component component2 = Manufacturer.newCompositeComponent("component2", null);
        List<Component> components = Manufacturer.bundleOf(component1_1, component2, part);

        Component component3 = Manufacturer.newCompositeComponent("component3", components);

        List<Component> productComponents = Manufacturer.bundleOf(component1_2, component3, part2);
        Product product = Manufacturer.newProduct("product1", productComponents);

        for(int i = 1; i < 50; ++i) {
            System.out.println("Day: " + i + '\n');

            product.tryProduce();
            System.out.println(product.describe());
            System.out.println(Manufacturer.stockStatus());
            System.out.println("----------------------------------------------------------------------------");
            Manufacturer.advanceDay();
        }
    }
}
