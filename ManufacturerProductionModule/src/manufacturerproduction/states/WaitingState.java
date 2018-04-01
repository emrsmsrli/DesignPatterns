package manufacturerproduction.states;

public class WaitingState implements State {
    @Override
    public State nextState() {
        return new ReadyState();
    }

    @Override
    public String toString() {
        return "Waiting";
    }
}
