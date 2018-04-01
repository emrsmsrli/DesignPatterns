package manufacturerproduction.states;

import manufacturerproduction.util.Utils;

public class OrderedState extends LastingState {
    public OrderedState(int durationInDays) {
        super(durationInDays);
    }

    @Override
    protected State newNextState() {
        return new InQualityControlState(Utils.randomInt(1, 4));
    }

    @Override
    public String toString() {
        return "Ordered " + super.toString();
    }
}
