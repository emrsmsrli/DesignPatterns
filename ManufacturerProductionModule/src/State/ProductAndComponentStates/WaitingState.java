package State.ProductAndComponentStates;

import State.State;
import State.ReadyState;

public class WaitingState extends State {
    public State tick(){
        return new ReadyState();
    }

    public String getState(){
        return "Waiting";
    }
}
