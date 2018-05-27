package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteClass extends CompositeProjectElement {
    private List<CompositeProjectElement> components;

    public ConcreteClass(String name){
        super(name);
        components = new ArrayList<>();
    }

    public void addElement(CompositeProjectElement element){
        components.add(element);
    }

    @Override
    public List<ConcreteVariable> getVariables() {
        List<ConcreteVariable> variables = new ArrayList<>();
        for(CompositeProjectElement component: components)
            variables.addAll(component.getVariables());
        return variables;
    }

    @Override
    public List<ConcreteMethod> getMethods() {
        List<ConcreteMethod> methods = new ArrayList<>();
        for(CompositeProjectElement component: components)
            methods.addAll(component.getMethods());
        return methods;
    }

    @Override
    public List<ConcreteVariable> getVariablesInMethods() {
        List<ConcreteVariable> variables = new ArrayList<>();
        for(CompositeProjectElement component: components)
            variables.addAll(component.getVariablesInMethods());
        return variables;
    }

    @Override
    public List<ConcreteClass> getClasses() {
        List<ConcreteClass> classes = new ArrayList<>();
        classes.add(this);
        for(CompositeProjectElement component: components)
            classes.addAll(component.getClasses());
        return classes;
    }
}
