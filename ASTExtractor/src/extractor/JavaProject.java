package extractor;

import java.util.ArrayList;
import java.util.List;

public class JavaProject {
    private List<ConcreteClass> classes;

    public JavaProject(){
        classes = new ArrayList<ConcreteClass>();
    }

    public void addClass(ConcreteClass concreteClass){
        classes.add(concreteClass);
    }

    public float getAverageNumberOfMethodsPerClass(){
        return getMethodsCount() / classes.size();
    }

    public float getAverageNumberOfVariablesPerClass(){
        return getVariablesCount() / classes.size();
    }

    public float getAverageNumberOfVariablesPerMethod(){
        int counter = 0;
        for(ConcreteClass concreteClass: classes){
            counter += concreteClass.getVariableCountInMethods();
        }
        return counter / getMethodsCount();
    }

    private int getMethodsCount(){
        int counter = 0;
        for(ConcreteClass concreteClass: classes){
            counter += concreteClass.getMethodCount();
        }
        return counter;
    }

    private int getVariablesCount()
    {
        int counter = 0;
        for(ConcreteClass concreteClass: classes){
            counter += concreteClass.getTotalVariableCount();
        }
        return counter;
    }
}
