package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteVariable extends CompositeProjectElement {

    public ConcreteVariable(String name) {
        super(name);
    }

    @Override
    public List<ConcreteVariable> getVariables() {
        List<ConcreteVariable> variables = new ArrayList<>();
        variables.add(this);
        return variables;
    }

    @Override
    public List<ConcreteMethod> getMethods() {
        return null;
    }

    @Override
    public List<ConcreteVariable> getVariablesInMethods() {
        return null;
    }

    @Override
    public List<ConcreteClass> getClasses() {
        return null;
    }
}
