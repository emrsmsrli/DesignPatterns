package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.util.Utils;

import java.util.List;

public class CompositeComponent extends MultiComponent {

    public CompositeComponent(String name, List<Component> subComponents) {
        super(name, subComponents);
    }

    @Override
    public void tryProduce() {
        if(!Manufacturer.canProduceComponent())
            return;
        super.tryProduce();
    }

    @Override
    public void describe(StringBuilder builder, int depth) {
        Utils.indent(builder, depth);
        super.describe(builder, depth);
    }

    @Override
    public String toString() {
        return "CompositeComponent(" + getName() + ") - " + state;
    }
}
