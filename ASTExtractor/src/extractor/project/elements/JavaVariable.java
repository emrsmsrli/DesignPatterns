package extractor.project.elements;

public class JavaVariable extends JavaElement {
    public JavaVariable(String name) {
        super(name);
    }

    @Override
    public int getClassCount() {
        return 0;
    }

    @Override
    public int getMethodCount() {
        return 0;
    }

    @Override
    public int getVariableCount(boolean includeFields) {
        return 1;
    }

    @Override
    public String getName() {
        return "[VARIABLE] " + super.getName();
    }
}
