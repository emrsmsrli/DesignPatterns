package manufacturerproduction.state.part;

import manufacturerproduction.state.State;
import manufacturerproduction.state.WaitingState;

/**
 * A state template with duration
 */
public abstract class LastingState extends WaitingState {
    private int durationInDays;

    public LastingState(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public void advanceTime() {
        if(durationInDays > 0) durationInDays--;
    }

    public boolean isFinished() {
        return durationInDays == 0;
    }

    @Override
    public State nextState() {
        advanceTime();
        if(isFinished())
            return newNextState();
        return this;
    }

    protected abstract State newNextState();
}