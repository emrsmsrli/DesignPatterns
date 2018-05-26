package extractor;

public class ConcreteVariable extends CompositeComponent{

    public ConcreteVariable(String name) {
        super(name);
    }

    @Override
    public int getVariableCount() {
        return 1;
    }

    @Override
    public int getMethodCount() {return 0; }

    @Override
    public int getVariableCountInMethods() {
        return 0;
    }
}
