import State.PartStates.OrderedState;
import State.ReadyState;

public class Part extends Component {
    private PartInventory inventory;

    public Part(String name, PartInventory inventory){
        super(name, new OrderedState((int)(Math.random() * 9 + 1)));
        this.inventory = inventory;
    }

    @Override
    public void produce() {
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
        return getName();
    }

    @Override
    public boolean isSubComponentsProduced() {
        return isReady();
    }

    @Override
    public boolean tick(){
        if(!isReady()){
            this.setState(this.getState().tick());
            if(isReady()){
                produce();
                return true;
            }
            return false;
        } else
            return true;
    }
}
