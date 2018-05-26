package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMethod extends CompositeComponent {
    private List<ConcreteVariable> variables;

    public ConcreteMethod(String name){
        super(name);
        variables = new ArrayList<>();
    }

    public void addVariable(ConcreteVariable variable){
        variables.add(variable);
    }

    @Override
    public int getVariableCount() {
        return variables.size();
    }

    @Override
    public int getMethodCount() {
        return 1;
    }

    @Override
    public int getVariableCountInMethods() {
        return variables.size();
    }
}
