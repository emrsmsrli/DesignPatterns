package manufacturerproduction.states;

public class ReadyState implements State {
    @Override
    public State nextState() {
        return this;
    }

    @Override
    public String toString() {
        return "Ready";
    }
}
