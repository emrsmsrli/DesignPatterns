

public class PartInventory {
    private int partCount;
    private PartState state;

    public PartInventory(){
        partCount = 0;
    }

    public int getPartCount(){
        return partCount;
    }

    public void addPart(Part part){
        partCount++;
    }

    public void removePart(Part part){
        if(partCount > 0)
            partCount --;
        else
            System.out.println("There is no part to remove");
    }
}
