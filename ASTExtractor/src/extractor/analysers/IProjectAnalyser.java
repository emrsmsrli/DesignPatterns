package extractor.analysers;

import extractor.printers.IProjectPrinter;
import extractor.projects.IProject;

public interface IProjectAnalyser {
    public void printAnalysis(IProject project);
    /*
    public int getClassCount(IProject project);
    public int getVariablesCountInClass(IProject project);
    public int getMethodsCountInClass(IProject project);
    public int getVariableCountInMethods(IProject project);
    public float getAverageNumberOfMethodsPerClass(IProject project);
    public float getAverageNumberOfVariablesPerClass(IProject project);
    public float getAverageNumberOfVariablesPerMethod(IProject project);
    */
}
