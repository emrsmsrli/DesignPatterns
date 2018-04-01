package manufacturerproduction.states;

import manufacturerproduction.util.Random;

public class OrderedState extends LastingState {
    public OrderedState(int durationInDays) {
        super(durationInDays);
    }

    @Override
    protected State newNextState() {
        return new InQualityControlState(Random.i(1, 4));
    }

    @Override
    public String toString() {
        return "Ordered " + super.toString();
    }
}
