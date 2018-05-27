package extractor.project.elements;

import java.util.List;
import java.util.function.ToIntFunction;

public abstract class JavaCompositeElement extends JavaElement {
    final List<JavaElement> elements;

    JavaCompositeElement(String name, List<JavaElement> elements) {
        super(name);
        this.elements = elements;
    }

    @Override
    public int getClassCount() {
        return sumWith(JavaElement::getClassCount);
    }

    @Override
    public int getMethodCount() {
        return sumWith(JavaElement::getMethodCount);
    }

    @Override
    public int getVariableCount(boolean includeFields) {
        return sumWith(e -> e.getVariableCount(includeFields));
    }

    @Override
    public void buildTreeToString(StringBuilder sb, int depth) {
        super.buildTreeToString(sb, depth);
        for(JavaElement element : elements)
            element.buildTreeToString(sb, depth + 1);
    }

    private int sumWith(ToIntFunction<JavaElement> function) {
        return elements.stream().mapToInt(function).sum();
    }
}
