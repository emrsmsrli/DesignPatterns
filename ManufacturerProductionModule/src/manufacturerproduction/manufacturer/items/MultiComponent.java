package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.state.State;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiComponent extends Component {
    private List<Component> subComponents;

    public MultiComponent(String name, State state) {
        super(name, state);
        subComponents = new ArrayList<>();
    }

    public void addComponent(Component component) {
        subComponents.add(component);
    }

    @Override
    public void tryProduce() {
        if(isProduced())
            return;
        boolean subComponentsProduced = true;
        for(Component component : subComponents) {
            component.tryProduce();
            subComponentsProduced &= component.isProduced();
        }
        if(!subComponentsProduced)
            return;
        for(Component component : subComponents)
            Manufacturer.use(component);
        state = state.nextState();
        Manufacturer.produce(this);
    }

    @Override
    public void describe(StringBuilder builder, int depth) {
        builder.append(this).append('\n');
        for(Component component : subComponents)
            component.describe(builder, depth + 1);
    }
}
