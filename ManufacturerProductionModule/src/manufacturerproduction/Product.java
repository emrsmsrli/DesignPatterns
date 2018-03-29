import java.util.HashMap;
import java.util.Map;

public class Product {
    private Map<Component, Integer> components;
    private ProductInventory inventory;
    private ComponentState state;

    public <T extends Iterable<Component>> Product(T componentIterable, ProductInventory productInventory){
        inventory = productInventory;
        components = new HashMap<>();
        //add Components to hashmap
        for(Component component: componentIterable)
            components.put(component, 1);
    }

    public Map<Component, Integer> getComponents() {
        return components;
    }
}
