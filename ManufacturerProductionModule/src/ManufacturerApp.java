import java.util.ArrayList;
import java.util.List;

public class ManufacturerApp {

    public static void main(String[] args) {
        //Inventories
        ProductInventory productInventory = new ProductInventory();
        ComponentInventory componentInventory = new ComponentInventory();
        PartInventory partInventory = new PartInventory();

        //All elements list
        List<ObjectWithState> allElements = new ArrayList<>();

        //Components and products
        Component part = new Part("part1", partInventory);
        Component part2 = new Part("part2", partInventory);

        ArrayList<Component> components = new ArrayList<>();
        Component component1 = new CompositeComponent("component1", null, componentInventory);
        Component component2 = new CompositeComponent("component2", null, componentInventory);
        components.add(component1);
        components.add(component2);
        components.add(part);
        Component component3 = new CompositeComponent("component3",components, componentInventory);

        //Product
        ArrayList<Component> productComponents = new ArrayList<>();
        productComponents.add(component1);
        productComponents.add(component3);
        productComponents.add(part2);
        Product product = new Product("product1", productComponents, productInventory);

        allElements.add(part);
        allElements.add(part2);
        allElements.add(component1);
        allElements.add(component2);
        allElements.add(component3);
        allElements.add(product);

        for(int i= 1; i < 1000; i++){
            if(allElements.size() == 0)
                continue;

            System.out.println("Day: " + i);
            System.out.println("----------------------------------------------------------------------------");

            for(int counter = 0; counter <= 5 && counter < allElements.size(); counter++)
            {
                ObjectWithState object = allElements.get(counter);
                System.out.println("Name: " + object.getAllComponentsName() + " class: " + object.getClass());
                object.printState();
                if(object.tick()){
                    allElements.remove(counter);
                }
                System.out.println("---------------------------");
                counter++;
            }
        }
    }
}
