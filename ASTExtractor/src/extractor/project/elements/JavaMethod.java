package extractor.project.elements;

import java.util.List;

public class JavaMethod extends JavaCompositeElement {
    public JavaMethod(String name, List<JavaElement> elements) {
        super(name, elements);
    }

    @Override
    public int getMethodCount() {
        return super.getMethodCount() + 1; // this method
    }

    @Override
    public String getName() {
        return "[METHOD] " + super.getName();
    }
}
