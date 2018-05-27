package extractor.project.elements;

import java.util.List;

public class JavaClass extends JavaCompositeElement {
    public JavaClass(String name, List<JavaElement> elements) {
        super(name, elements);
    }

    @Override
    public int getClassCount() {
        return super.getClassCount() + 1; // this class
    }

    @Override
    public int getVariableCount(boolean includeFields) {
        return super.getVariableCount(includeFields) - (includeFields ? 0 : getFieldCount());
    }

    private int getFieldCount() {
        return (int) elements.stream().filter(e -> e instanceof JavaVariable).count();
    }

    @Override
    public String getName() {
        return "[CLASS] " + super.getName();
    }
}
