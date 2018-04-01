package manufacturerproduction.manufacturer.items;

import manufacturerproduction.states.WaitingState;

public class Product extends MultiComponent {

    public Product(String name) {
        super(name, new WaitingState());
    }

    public String describe() {
        StringBuilder builder = new StringBuilder(128);
        describe(builder, 0);
        return builder.append("Total remaining days: ")
                .append(getRemainingDays())
                .append('\n').toString();
    }

    @Override
    public String toString() {
        return "Product(" + getName() + ") - " + state;
    }
}
