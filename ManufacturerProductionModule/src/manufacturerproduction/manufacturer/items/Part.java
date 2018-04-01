package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.states.LastingState;
import manufacturerproduction.states.State;
import manufacturerproduction.util.Utils;

public class Part extends Component {
    public Part(String name, State state) {
        super(name, state);
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
