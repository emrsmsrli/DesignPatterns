import java.util.ArrayList;
import java.util.List;

public class PartInventory implements Inventory{
    private List<Part> parts;

    public PartInventory(){
        parts = new ArrayList<>();
    }

    public boolean hasStock(Object part){
        if( !(part instanceof Part) || parts.indexOf(part) == -1)
            return false;
        return true;
    }

    public void addItem(Object part){
        if(part.getClass() == Part.class)
            parts.add((Part)part);
    }

    public void removeItem(Object part){
        if(part instanceof Part){
            Part tempPart = (Part) part;
            parts.remove(tempPart);
            System.out.println("Item removed from inventory. Name: " + tempPart.getName());
        }
        else
            System.out.println("There is no such part");
    }

    @Override
    public int getItemCount() {
        return parts.size();
    }
}
