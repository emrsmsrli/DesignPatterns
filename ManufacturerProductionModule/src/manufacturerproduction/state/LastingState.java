package manufacturerproduction.state;

/**
 * A state template with duration
 */
public abstract class LastingState extends WaitingState {
    private int durationInDays;

    public LastingState(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    private void advanceTime() {
        if(durationInDays > 0) durationInDays--;
    }

    private boolean isFinished() {
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

    @Override
    public String toString() {
        return durationInDays + " days to go";
    }
}