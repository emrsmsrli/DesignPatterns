package extractor.analysers;

import extractor.printers.IProjectPrinter;
import extractor.printers.JavaProjectPrinter;
import extractor.projects.IProject;
import extractor.javaProjectElements.ConcreteClass;
import extractor.javaProjectElements.ConcreteMethod;
import extractor.javaProjectElements.ConcreteVariable;

import java.util.List;

public class JavaProjectAnalyser implements IProjectAnalyser {

    @Override
    public void printAnalysis(IProject project) {
        IProjectPrinter projectPrinter = JavaProjectPrinter.getInstance();

        projectPrinter.printTotalClassCount(getClassCount(project));
        /*

        projectPrinter.printNumberOfClasses(project);
        projectPrinter.printNumOfMethodsForEachClass(project);
        projectPrinter.printNumOfVariableForEachClass(project);
        projectPrinter.printNumOfVariablesForEachMethod(project);
        projectPrinter.printAverageNumberOfMethodsPerClass(project);
        projectPrinter.printAverageNumberOfVariablesPerClass(project);
        projectPrinter.printAverageNumberOfVariablesPerMethod(project);
        */
    }

    private int getVariablesCountInClass(ConcreteClass clazz) {
        List<ConcreteVariable> variables = clazz.getVariables();
        if(variables == null)
            return 0;
        return variables.size();
    }

    private int getMethodsCountInClass(ConcreteClass clazz) {
        List<ConcreteMethod> methods = clazz.getMethods();
        if(methods == null)
            return 0;
        return methods.size();
    }

    private int getVariableCountInMethod(ConcreteMethod method) {
        List<ConcreteVariable> variables = method.getVariablesInMethods();
        if(variables == null)
            return 0;
        return variables.size();
    }

    private float getAverageNumberOfMethodsPerClass(IProject project) {
        int classCount = getClassCount(project);
        if(classCount == 0)
            return 0;
        return getMethodCount(project) / classCount;
    }

    private float getAverageNumberOfVariablesPerClass(IProject project) {
        int classCount = getClassCount(project);
        if(classCount == 0)
            return 0;
        return getVariableCount(project) / classCount;
    }

    private float getAverageNumberOfVariablesPerMethod(IProject project) {
        int methodCount = getMethodCount(project);
        if(methodCount == 0)
            return 0;
        return getVariablesInMethods(project) / methodCount;
    }

    private int getClassCount(IProject project) {
        List<ConcreteClass> classes = project.getClasses();
        if(classes == null)
            return 0;
        return classes.size();
    }


    private int getMethodCount(IProject project) {
        List<ConcreteMethod> methods = project.getMethods();
        if(methods == null)
            return 0;
        return methods.size();
    }

    private int getVariableCount(IProject project) {
        List<ConcreteVariable> variables = project.getVariables();
        if(variables == null)
            return 0;
        return variables.size();
    }

    private int getVariablesInMethods(IProject project) {
        List<ConcreteVariable> variables = project.getVariablesInMethods();
        if(variables == null)
            return 0;
        return variables.size();
    }
}
