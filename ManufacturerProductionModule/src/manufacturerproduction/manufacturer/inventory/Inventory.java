package manufacturerproduction.manufacturer.inventory;

public interface Inventory<T> {
    boolean put(T item);
    T pop(String name);
}
