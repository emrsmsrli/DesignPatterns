

public class ComponentInventory {
    private int componentCount;

    public ComponentInventory(){
        componentCount = 0;
    }

    public int getComponentCount(){
        return componentCount;
    }

    public void addComponent(Component component){
        componentCount++;
    }

    public void removeComponent(Component component){
        if(componentCount > 0)
            componentCount--;
        else
            System.out.println("There is no component to remove");
    }
}
