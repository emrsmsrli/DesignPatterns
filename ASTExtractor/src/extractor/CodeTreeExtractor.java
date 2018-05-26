package extractor;

public class CodeTreeExtractor {
    public static void main(String[] args) {
        JavaProject project = new JavaProject();

        ConcreteClass class1 = new ConcreteClass("class1");
        ConcreteClass class2 = new ConcreteClass("class2");
        ConcreteClass class3 = new ConcreteClass("class3");

        ClassElement method1 = new ConcreteMethod("method1");
        ClassElement method2 = new ConcreteMethod("method2");
        ClassElement method3 = new ConcreteMethod("method3");

        ClassElement var1 = new ConcreteMethod("var1");
        ClassElement var2 = new ConcreteMethod("var2");
        ClassElement var3 = new ConcreteMethod("var3");

        //((ConcreteMethod) method2).addVariable(var1);
        //((ConcreteMethod) method2).addVariable(var1);
    }
}
