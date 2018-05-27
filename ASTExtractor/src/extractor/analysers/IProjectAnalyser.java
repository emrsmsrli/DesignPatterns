package extractor;

public interface IProjectAnalyser {
    public int getClassCount(IJavaProject project);
    public int getVariablesCountInClass(IJavaProject project);
    public int getMethodsCountInClass(IJavaProject project);
    public int getVariableCountInMethods(IJavaProject project);
    public float getAverageNumberOfMethodsPerClass(IJavaProject project);
    public float getAverageNumberOfVariablesPerClass(IJavaProject project);
    public float getAverageNumberOfVariablesPerMethod(IJavaProject project);
}
