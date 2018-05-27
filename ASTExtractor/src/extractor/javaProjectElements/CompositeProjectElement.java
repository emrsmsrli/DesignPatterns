package extractor.javaProjectElements;

import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;
import extractor.javaProjectElements.ConcreteVariable;

import java.util.List;

public abstract class CompositeProjectElement {
    private String name;

    public CompositeProjectElement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract List<ConcreteVariable> getVariables();
    public abstract List<ConcreteMethod> getMethods();
    public abstract List<ConcreteVariable> getVariablesInMethods();
    public abstract List<ConcreteClass> getClasses();
}
