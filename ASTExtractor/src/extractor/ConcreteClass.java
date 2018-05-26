package extractor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteClass {
    private String name;
    private List<ClassElement> classElements;

    public ConcreteClass(String name){
        classElements = new ArrayList<>();
        this.name = name;
    }

    public void addElement(ClassElement element){
        classElements.add(element);
    }

    public int getMethodCount(){
        int counter = 0;
        for(ClassElement element: classElements){
            if(element instanceof ConcreteMethod)
                counter++;
        }
        return counter;
    }

    public int getVariableCountInMethods(){
        int counter = 0;
        for(ClassElement element: classElements){
            if(element instanceof ConcreteMethod)
                counter += element.getVariableCount();
        }
        return counter;
    }

    public int getTotalVariableCount(){
        int counter = 0;
        for(ClassElement element: classElements){
            counter += element.getVariableCount();
        }
        return counter;
    }
}
