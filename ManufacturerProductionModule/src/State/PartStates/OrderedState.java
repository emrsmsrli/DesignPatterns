package State.PartStates;

import State.State;

public class OrderedState extends PartState {
    public OrderedState(int processDay){
        super(processDay);
    }

    public State tick(){
        this.decreaseDay();
        if(this.getRemainingDays() == 0)
            return new InQualityControlState((int) (Math.random() * 2 + 1 ));
        else {
            return this;
        }
    }

    public String getState(){
        return "Ordered";
    }
}