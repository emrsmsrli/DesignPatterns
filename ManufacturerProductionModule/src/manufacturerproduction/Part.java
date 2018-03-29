


public class Part extends Component {
    private PartInventory partInventory;

    public Part(PartInventory inventory){
        partInventory = inventory;
    }

    @Override
    public void produce() {
        partInventory.addPart(this);
    }
}
