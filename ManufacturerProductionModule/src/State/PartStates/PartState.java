package State.PartStates;

import State.ReadyState;
import State.State;

public abstract class PartState extends State{
    private int processDay;

    public void decreaseDay(){
        if(processDay>0) processDay--;
    }

    public int getRemainingDays(){
        return processDay;
    }

    public PartState(int processDay){
        this.processDay = processDay;
    }
}

