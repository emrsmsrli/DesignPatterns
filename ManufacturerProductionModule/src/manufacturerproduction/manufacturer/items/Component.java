package manufacturerproduction.manufacturer.items;

import manufacturerproduction.state.ReadyState;
import manufacturerproduction.state.State;

public abstract class Component implements Producable {
    private String name;
    protected State state;

    public Component(String name, State state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isProduced() {
        return state instanceof ReadyState;
    }
}
