package extractor.projects;

import extractor.javaProjectElements.CompositeProjectElement;
import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;
import extractor.javaProjectElements.ConcreteVariable;

import java.util.ArrayList;
import java.util.List;

public class JavaProject implements IProject {
    private List<ConcreteClass> classes;

    public JavaProject(){
        classes = new ArrayList<>();
    }

    public void addClass(ConcreteClass concreteClass){
        classes.add(concreteClass);
    }

    public List<ConcreteClass> getClasses(){
        List<ConcreteClass> classList = new ArrayList<>();
        for(ConcreteClass clazz: classes)
            classList.addAll(clazz.getClasses());
        return classList;
    }

    @Override
    public List<ConcreteVariable> getVariables() {
        List<ConcreteVariable> variables = new ArrayList<>();
        for(ConcreteClass clazz: classes)
            variables.addAll(clazz.getVariables());
        return variables;
    }

    @Override
    public List<ConcreteMethod> getMethods() {
        List<ConcreteMethod> methods = new ArrayList<>();
        for(ConcreteClass clazz: classes)
            methods.addAll(clazz.getMethods());
        return methods;
    }

    @Override
    public List<ConcreteVariable> getVariablesInMethods() {
        List<ConcreteVariable> variables = new ArrayList<>();
        for(CompositeProjectElement clazz: classes)
            variables.addAll(clazz.getVariablesInMethods());
        return variables;
    }
}
