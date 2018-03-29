import java.util.ArrayList;
import java.util.List;

public class ComponentInventory implements Inventory{
    private List<Component> components;

    public ComponentInventory(){
        components = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    @Override
    public boolean hasStock(Object component) {
        if(component.getClass() != CompositeComponent.class || components.indexOf(component) == -1)
            return false;
        return true;
    }

    @Override
    public void addItem(Object component) {
        if(component instanceof Component)
            components.add((Component)component);
    }

    @Override
    public void removeItem(Object component) {
        if(component instanceof CompositeComponent){
            CompositeComponent tempComponent = (CompositeComponent) component;
            components.remove(tempComponent);
            System.out.println("Item removed from inventory. Name: " + tempComponent.getName());
        }
        else
            System.out.println("There is no such component");
    }
}
