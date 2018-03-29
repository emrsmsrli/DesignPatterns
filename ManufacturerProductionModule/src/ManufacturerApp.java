import java.util.ArrayList;
import java.util.List;

public class ManufacturerApp {

    public static void main(String[] args) {
        ProductInventory productInventory = new ProductInventory();
        ComponentInventory componentInventory = new ComponentInventory();
        PartInventory partInventory = new PartInventory();

        Component c = new CompoziteComponent();
        Component a = new Part();
        ArrayList<Component> componentList = new ArrayList<>();
        componentList.add(a);
        componentList.add(c);
        Product p = new Product(componentList);
        System.out.println("Product " + p.getComponents());
    }
}

