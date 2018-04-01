package manufacturerproduction.states;

import manufacturerproduction.util.Utils;

public class OrderedState extends LastingState {
    private int inQualityDuration = Utils.randomInt(1, 4);
    public OrderedState(int durationInDays) {
        super(durationInDays);
    }

    @Override
    protected State newNextState() {
        return new InQualityControlState(inQualityDuration);
    }

    @Override
    public int getDurationInDays() {
        return super.getDurationInDays() + inQualityDuration;
    }

    @Override
    public String toString() {
        return "Ordered " + super.toString();
    }
}
