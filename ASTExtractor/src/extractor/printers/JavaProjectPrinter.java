package extractor;

import extractor.analysers.IProjectAnalyser;
import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;

public class JavaProjectPrinter {
    private static JavaProjectPrinter instance = null;

    public static JavaProjectPrinter getInstance() {
        if(instance == null) {
            instance = new JavaProjectPrinter();
        }
        return instance;
    }

    public void printNumberOfClasses(IProjectAnalyser analyser, IJavaProject project){
        System.out.println(analyser.getClassCount(project) + " class exist.");
    }

    public void printNumOfMethodsForEachClass(IJavaProject project){
        for(ConcreteClass clazz: project.getClasses())
            System.out.println("Class: " + clazz.getName() + " has " + clazz.getMethods().size() + " method.");
    }

    public void printNumOfVariableForEachClass(IJavaProject project){
        for(ConcreteClass clazz: project.getClasses())
            System.out.println("Class: " + clazz.getName() + " has " +  clazz.getVariables().size() + " variable.");
    }

    public void printNumOfVariablesForEachMethod(IJavaProject project){
        for(ConcreteClass clazz: project.getClasses())
            for(ConcreteMethod method: clazz.getMethods())
                System.out.println("Method: " + method.getName() + " has " + method.getVariablesInMethods().size()
                        + " method.");
    }

    public void printAverageNumberOfMethodsPerClass(IProjectAnalyser analyser){
        System.out.println("Average number of methods per class " + project.getAverageNumberOfMethodsPerClass());
    }

    public void printAverageNumberOfVariablesPerClass(IProjectAnalyser analyser){
        System.out.println("Average number of variables per class " + project.getAverageNumberOfVariablesPerClass());
    }

    public void printAverageNumberOfVariablesPerMethod(IProjectAnalyser analyser){
        System.out.println("Average number of variables per method " + project.getAverageNumberOfVariablesPerMethod());
    }
}
