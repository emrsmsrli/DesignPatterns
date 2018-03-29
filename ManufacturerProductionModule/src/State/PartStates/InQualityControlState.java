package State.PartStates;

import State.State;
import State.ReadyState;

class InQualityControlState extends PartState{
    public InQualityControlState(int processDay){
        super(processDay);
    }

    public State tick(){
        this.decreaseDay();
        if(this.getRemainingDays() == 0)
            return new ReadyState();
        else {
            return this;
        }
    }

    public String getState(){
        return "In quality control";
    }
}
