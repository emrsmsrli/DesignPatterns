import State.ProductAndComponentStates.WaitingState;

import java.util.ArrayList;
import java.util.List;

public class CompositeComponent extends Component {
    private ComponentInventory inventory;
    private List<Component> components;

    public CompositeComponent(String name, ArrayList<Component> components, ComponentInventory componentInventory) {
        super(name, new WaitingState());
        this.components = components;
        inventory = componentInventory;
    }

    @Override
    public void produce() {
        if(components != null) {
            for(Component component: components)
                component.removeItemFromInventory();
        }
        addItemToInventory();
        System.out.println("Item produced. Name: " + getName());
    }

    @Override
    public void removeItemFromInventory() {
        inventory.removeItem(this);
    }

    @Override
    public void addItemToInventory() {
        inventory.addItem(this);
    }


    @Override
    public String getAllComponentsName(){
        if(components == null)
            return getName();
        StringBuilder name = new StringBuilder(getName());
        for(Component component: components)
            name.append("/").append(component.getName());
        return name.toString();
    }


    @Override
    public boolean isSubComponentsProduced() {
        if(components == null)
            return true;
        for(Component component: components)
            if(!component.isSubComponentsProduced())
                return false;
        return true;
    }
}
