package extractor.projects;

import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;
import extractor.javaProjectElements.ConcreteVariable;

import java.util.List;

public interface IJavaProject {
    public void addClass(ConcreteClass clazz);
    public List<ConcreteVariable> getVariables();
    public List<ConcreteMethod> getMethods();
    public List<ConcreteVariable> getVariablesInMethods();
    public List<ConcreteClass> getClasses();
}
