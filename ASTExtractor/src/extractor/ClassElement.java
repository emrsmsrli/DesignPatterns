package extractor;

//todo change Class Name.
public abstract class ClassElement {
    private String name;

    public ClassElement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getVariableCount();
}
