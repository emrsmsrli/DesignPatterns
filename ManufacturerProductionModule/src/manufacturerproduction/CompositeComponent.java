public class CompositeComponent extends Component {
    private ComponentInventory inventory;
    private ComponentState state;

    public CompositeComponent(ComponentInventory componentInventory) {
        inventory = componentInventory;
    }

    @Override
    public void produce() {
        inventory.addComponent(this);
    }
}
