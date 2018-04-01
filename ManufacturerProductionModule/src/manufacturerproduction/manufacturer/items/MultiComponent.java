package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.states.State;
import manufacturerproduction.util.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiComponent extends Component {
    private List<Component> subComponents;

    public MultiComponent(String name, List<Component> subComponents, State state) {
        super(name, state);
        if(subComponents == null)
            this.subComponents = new ArrayList<>();
        else this.subComponents = subComponents;
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

    @Override
    public int getRemainingDays() {
        int days = 0;
        for(Component component : subComponents)
            days = Utils.max(days, component.getRemainingDays());
        return days;
    }
}
