package extractor.printers;

import extractor.projects.IProject;
import extractor.analysers.IProjectAnalyser;
import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;

public class JavaProjectPrinter implements IProjectPrinter {
    private static JavaProjectPrinter instance = null;

    public static JavaProjectPrinter getInstance() {
        if(instance == null) {
            instance = new JavaProjectPrinter();
        }
        return instance;
    }

    public void printTotalClassCount(int count){
        System.out.println(count + " class exist.");
    }

    public void printNumberOfMethodForClass(String className, int methodCount){
        System.out.println("Class: " + className + " has " + methodCount + " method(s).");
    }

    public void printNumberOfVariableForClass(String className, int variableCount){
        System.out.println("Class: " + className + " has " + variableCount + " variable(s).");
    }

    public void printNumberOfVariableForMethod(String methodName, int variableCount){
        System.out.println("Method: " + methodName + " has " + variableCount + " variable(s).");
    }

    public void printAverageNumberOfMethodsPerClass(int average){
        System.out.println("Average number of methods per class " + average);
    }

    public void printAverageNumberOfVariablesPerClass(int average){
        System.out.println("Average number of variables per class " + average);
    }

    public void printAverageNumberOfVariablesPerMethod(int average){
        System.out.println("Average number of variables per method " + average);
    }
}
