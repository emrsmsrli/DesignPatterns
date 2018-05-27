package extractor.project.elements;

public abstract class JavaElement {
    private final String name;

    JavaElement(String name) {
        this.name = name;
    }

    public abstract int getClassCount();
    public abstract int getMethodCount();
    public abstract int getVariableCount(boolean includeFields);

    void buildTreeToString(StringBuilder sb, int depth) {
        for(int i = 0; i < depth; ++i)
            sb.append("  ");
        sb.append(getName()).append("\n");
    }

    String getName() {
        return name;
    }
}
