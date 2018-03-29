import State.ProductAndComponentStates.WaitingState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product extends ObjectWithState{
    private List<Component> components;
    private ProductInventory inventory;

    public Product(String name, ArrayList<Component> components, ProductInventory productInventory){
        super(name, new WaitingState());
        this.components = components;
        inventory = productInventory;
    }

    @Override
    public void produce(){
        if(components != null) {
            for(Component component: components) {
                component.removeItemFromInventory();
            }
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
    public String getAllComponentsName() {
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
