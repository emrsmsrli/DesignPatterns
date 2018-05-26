package extractor;

public abstract class CompositeComponent {
    private String name;

    public CompositeComponent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getVariableCount();
    public abstract int getMethodCount();
    public abstract int getVariableCountInMethods();
}
