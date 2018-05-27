package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMethod extends CompositeProjectElement {
    private List<ConcreteVariable> variables;

    public ConcreteMethod(String name){
        super(name);
        variables = new ArrayList<>();
    }

    public void addVariable(ConcreteVariable variable){
        variables.add(variable);
    }

    @Override
    public List<ConcreteVariable> getVariables() {
        return variables;
    }

    @Override
    public List<ConcreteMethod> getMethods() {
        List<ConcreteMethod> methods = new ArrayList<>();
        methods.add(this);
        return methods;
    }

    @Override
    public List<ConcreteVariable> getVariablesInMethods() {
        return variables;
    }

    @Override
    public List<ConcreteClass> getClasses() {
        return null;
    }
}
