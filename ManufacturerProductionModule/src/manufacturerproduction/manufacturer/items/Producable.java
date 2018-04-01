package manufacturerproduction.manufacturer.items;

public interface Producable {
    String getName();
    boolean isProduced();
    void tryProduce();
    void describe(StringBuilder builder, int depth);
    int getRemainingDays();
}
