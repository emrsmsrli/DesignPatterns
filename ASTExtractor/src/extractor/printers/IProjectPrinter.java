package extractor.printers;

public interface IProjectPrinter {
    public void printTotalClassCount(int count);
    public void printNumberOfMethodForClass(String className, int methodCount);
    public void printNumberOfVariableForClass(String className, int variableCount);
    public void printNumberOfVariableForMethod(String methodName, int variableCount);
    public void printAverageNumberOfMethodsPerClass(int average);
    public void printAverageNumberOfVariablesPerClass(int average);
    public void printAverageNumberOfVariablesPerMethod(int average);
}
