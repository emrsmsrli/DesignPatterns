import State.State;

public abstract class Component extends ObjectWithState{
    public Component(String name, State state){
        super(name, state);
    }
}
