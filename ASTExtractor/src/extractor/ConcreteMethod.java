package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMethod extends ClassElement {
    private List<ConcreteVariable> concreteVariables;

    public ConcreteMethod(String name){
        super(name);
        concreteVariables = new ArrayList<>();
    }

    public void addVariable(ConcreteVariable variable){
        concreteVariables.add(variable);
    }

    @Override
    public int getVariableCount() {
        return concreteVariables.size();
    }
}
