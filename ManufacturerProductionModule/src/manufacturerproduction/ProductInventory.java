

public class ProductInventory {
    private int productCount;

    public ProductInventory(){
        productCount = 0;
    }

    public int getProductCount(){
        return productCount;
    }

    public void addProduct(Product product){
        productCount++;
    }

    public void removeProduct(Product product){
        if(productCount > 0)
            productCount--;
        else
            System.out.println("There is no product to remove");
    }
}
