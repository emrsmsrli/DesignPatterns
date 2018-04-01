package manufacturerproduction.manufacturer;

import manufacturerproduction.manufacturer.inventory.*;
import manufacturerproduction.manufacturer.items.*;
import manufacturerproduction.states.OrderedState;
import manufacturerproduction.states.WaitingState;
import manufacturerproduction.util.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manufacturer {
    private static final Inventory<Product> productInventory = new ProducableInventory<>();
    private static final Inventory<Part> partInventory = new ProducableInventory<>();
    private static final Inventory<CompositeComponent> componentInventory = new ProducableInventory<>();

    private static int partProducedCount = 0;
    private static int componentProducedCount = 0;

    public static Product newProduct(String name, List<Component> components) {
        Product p = new Product(name);
        if(components != null)
            for(Component component : components) {
                p.addComponent(component);
            }
        return p;
    }

    public static Part newPart(String name) {
        return new Part(name, new OrderedState(Random.i(1, 11)));
    }

    public static CompositeComponent newCompositeComponent(String name, List<Component> subComponents) {
        CompositeComponent c = new CompositeComponent(name, new WaitingState());
        if(subComponents != null)
            for(Component subComponent : subComponents) {
                c.addComponent(subComponent);
            }
        return c;
    }

    public static void advanceDay() {
        partProducedCount = 0;
        componentProducedCount = 0;
    }

    public static boolean canProducePart() {
        return partProducedCount != 3;
    }

    public static boolean canProduceComponent() {
        return componentProducedCount != 2;
    }

    public static boolean use(Producable producable) {
        if(producable instanceof Part)
            return partInventory.pop(producable.getName()) != null;
        else if(producable instanceof CompositeComponent)
            return componentInventory.pop(producable.getName()) != null;
        return false;
    }

    public static void produce(Producable producable) {
        if(producable instanceof Product)
            productInventory.put((Product) producable);
        else if(producable instanceof CompositeComponent) {
            componentProducedCount++;
            componentInventory.put((CompositeComponent) producable);
        } else if(producable instanceof Part) {
            partProducedCount++;
            partInventory.put((Part) producable);
        }
    }

    public static String stockStatus() {
        return "-- Inventories ----------" + '\n' +
                "\tProduct: " + productInventory + '\n' +
                "\tComponent: " + componentInventory + '\n' +
                "\tPart: " + partInventory + '\n';
    }

    @SafeVarargs
    public static <T> List<T> bundleOf(T... elems) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elems);
        return list;
    }
}
