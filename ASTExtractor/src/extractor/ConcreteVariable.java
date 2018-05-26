package extractor;

public class ConcreteVariable extends ClassElement{

    public ConcreteVariable(String name) {
        super(name);
    }

    @Override
    public int getVariableCount() {
        return 1;
    }
}
