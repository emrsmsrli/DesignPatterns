package manufacturerproduction.manufacturer.inventory;

public interface Inventory<T> {
    void put(T item);
    void pop(String name);
}
