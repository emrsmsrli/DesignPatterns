package manufacturerproduction.state;

class InQualityControlState extends LastingState {
    public InQualityControlState(int durationInDays) {
        super(durationInDays);
    }

    @Override
    protected State newNextState() {
        return new ReadyState();
    }

    @Override
    public String toString() {
        return "In quality control " + super.toString();
    }
}
