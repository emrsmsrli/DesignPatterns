package extractor;

import java.util.List;

public class JavaProjectAnalyser implements IProjectAnalyser {
    @Override
    public int getClassCount(IJavaProject project) {
        List<ConcreteClass> classes = project.getClasses();
        if(classes == null)
            return 0;
        return classes.size();
    }

    @Override
    public int getVariablesCountInClass(ConcreteClass clazz) {
        List<ConcreteVariable> variables = clazz.getVariables();
        if(variables == null)
            return 0;
        return variables.size();
    }

    @Override
    public int getMethodsCountInClass(ConcreteClass clazz) {
        List<ConcreteMethod> methods = clazz.getMethods();
        if(methods == null)
            return 0;
        return methods.size();
    }

    @Override
    public int getVariableCountInMethods(ConcreteMethod method) {
        List<ConcreteVariable> variables = method.getVariablesInMethods();
        if(variables == null)
            return 0;
        return variables.size();
    }

    @Override
    public float getAverageNumberOfMethodsPerClass(IJavaProject project) {
        int classCount = getClassCount(project);
        if(classCount == 0)
            return 0;
        return getMethodsCountInClass();
    }

    @Override
    public float getAverageNumberOfVariablesPerClass(IJavaProject project) {
        return 0;
    }

    @Override
    public float getAverageNumberOfVariablesPerMethod(IJavaProject project) {
        return 0;
    }
}
