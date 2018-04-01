package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.states.State;

public class CompositeComponent extends MultiComponent {

    public CompositeComponent(String name, State state) {
        super(name, state);
    }

    @Override
    public void tryProduce() {
        if(!Manufacturer.canProduceComponent())
            return;
        super.tryProduce();
    }

    @Override
    public void describe(StringBuilder builder, int depth) {
        for(int i = 0; i < depth; ++i)
            builder.append('\t');
        super.describe(builder, depth);
    }

    @Override
    public String toString() {
        return "CompositeComponent(" + getName() + ") - " + state;
    }
}
