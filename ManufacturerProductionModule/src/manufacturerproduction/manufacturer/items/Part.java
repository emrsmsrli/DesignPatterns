package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.states.LastingState;
import manufacturerproduction.states.OrderedState;
import manufacturerproduction.util.Utils;

public class Part extends Component {
    public Part(String name) {
        super(name, new OrderedState(Utils.randomInt(1, 11)));
    }

    @Override
    public void tryProduce() {
        if(isProduced())
            return;
        state = state.nextState();
        if(!isProduced() || !Manufacturer.canProducePart())
            return;
        Manufacturer.produce(this);
    }

    @Override
    public void describe(StringBuilder builder, int depth) {
        Utils.indent(builder, depth);
        builder.append(this).append('\n');
    }

    @Override
    public int getRemainingDays() {
        if(isProduced())
            return 0;
        return ((LastingState) state).getDurationInDays();
    }

    @Override
    public String toString() {
        return "Part(" + getName() + ") - " + state;
    }
}
