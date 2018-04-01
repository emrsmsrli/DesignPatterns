package manufacturerproduction.manufacturer.items;

import manufacturerproduction.manufacturer.Manufacturer;
import manufacturerproduction.state.State;

public class Part extends Component {
    public Part(String name, State state) {
        super(name, state);
    }

    @Override
    public void tryProduce() {
        if(isProduced() || !Manufacturer.canProducePart())
            return;
        state = state.nextState();
        if(!isProduced())
            return;
        Manufacturer.produce(this);
    }

    @Override
    public void describe(StringBuilder builder, int depth) {
        for(int i = 0; i < depth; ++i)
            builder.append('\t');
        builder.append(this).append('\n');
    }

    @Override
    public String toString() {
        return "Part(" + getName() + ") - " + state;
    }
}
