package extractor.project;

import extractor.project.elements.JavaClass;
import extractor.project.elements.JavaElement;

import java.util.List;
import java.util.function.ToIntFunction;

public class JavaProject {
    private final List<JavaClass> classes;

    public JavaProject(List<JavaClass> classes) {
        this.classes = classes;
    }

    public int getClassCount() {
        return sumWith(JavaElement::getClassCount);
    }

    public int getMethodCount() {
        return sumWith(JavaElement::getMethodCount);
    }

    public int getVariableCountInClasses() {
        return getVars(true);
    }

    public int getVariableCountInMethods() {
        return getVars(false);
    }

    private int getVars(boolean withFields) {
        return sumWith(e -> e.getVariableCount(withFields));
    }

    private int sumWith(ToIntFunction<JavaElement> function) {
        return classes.stream().mapToInt(function).sum();
    }

    public float getAvgNumberOfMethods() {
        return getMethodCount() / (float) getClassCount();
    }

    public float getAvgNumOfVariablesInClasses() {
        return getVariableCountInClasses() / (float) getClassCount();
    }

    public float getAvgNumOfVariablesInMethods() {
        return getVariableCountInMethods() / (float) getClassCount();
    }

    public void printNameTree() {
        StringBuilder sb = new StringBuilder();
        for(JavaClass clazz : classes)
            clazz.buildTreeToString(sb, 0);
        System.out.println(sb.toString());
    }
}
