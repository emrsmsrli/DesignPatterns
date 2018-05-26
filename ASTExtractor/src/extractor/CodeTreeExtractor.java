package extractor;

public class CodeTreeExtractor {
    public static void main(String[] args) {
        JavaProject project = new JavaProject();

        ConcreteClass class1 = new ConcreteClass("class1");
        ConcreteClass class2 = new ConcreteClass("class2");
        ConcreteClass class3 = new ConcreteClass("class3");

        CompositeComponent method1 = new ConcreteMethod("method1");
        CompositeComponent method2 = new ConcreteMethod("method2");
        CompositeComponent method3 = new ConcreteMethod("method3");

        CompositeComponent var1 = new ConcreteMethod("var1");
        CompositeComponent var2 = new ConcreteMethod("var2");
        CompositeComponent var3 = new ConcreteMethod("var3");

        //((ConcreteMethod) method2).addVariable(var1);
        //((ConcreteMethod) method2).addVariable(var1);
    }
}
