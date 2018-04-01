package manufacturerproduction.manufacturer.inventory;

import manufacturerproduction.manufacturer.items.Producable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducableInventory<T extends Producable> implements Inventory<T> {
    private Map<String, List<Producable>> inventory;

    public ProducableInventory() {
        inventory = new HashMap<>();
    }

    @Override
    public boolean put(T item) {
        inventory.computeIfAbsent(item.getName(), k -> new ArrayList<>());
        List<Producable> producables = inventory.get(item.getName());
        return producables.add(item);
    }

    @Override
    public T pop(String name) {
        T producable = get(name);
        if(producable != null)
            inventory.get(name).remove(producable);
        return producable;
    }

    @SuppressWarnings("unchecked")
    private T get(String name) {
        if(!hasStock(name))
            return null;
        return (T)inventory.get(name).get(0);
    }

    private boolean hasStock(String name) {
        return !inventory.get(name).isEmpty();
    }

    @Override
    public String toString() {
        if(inventory.isEmpty())
            return "[ ]";
        StringBuilder builder = new StringBuilder("[");
        for(Map.Entry<String, List<Producable>> e : inventory.entrySet())
            builder.append(e.getKey()).append(" - ").append(e.getValue().size()).append(", ");
        return builder.append("\b\b]").toString();
    }
}
