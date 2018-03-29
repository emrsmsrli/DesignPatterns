public interface Inventory {
    public int getItemCount();
    public boolean hasStock(Object object);
    public void addItem(Object object);
    public void removeItem(Object object);
}
