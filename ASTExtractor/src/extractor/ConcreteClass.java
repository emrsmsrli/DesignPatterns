package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteClass extends CompositeComponent {
    private List<CompositeComponent> components;

    public ConcreteClass(String name){
        super(name);
        components = new ArrayList<>();
    }

    @Override
    public int getVariableCount() {
        int variableCount = 0;
        for(CompositeComponent component: components)
            variableCount += component.getVariableCount();
        return variableCount;
    }

    public void addElement(CompositeComponent element){
        components.add(element);
    }

    public int getMethodCount(){
        int methodCount = 0;
        for(CompositeComponent component: components){
            methodCount += component.getMethodCount();
        }
        return methodCount;
    }

    @Override
    public int getVariableCountInMethods() {
        int variableCount = 0;
        for(CompositeComponent component: components)
            variableCount += component.getVariableCount();
        return variableCount;
    }
}
