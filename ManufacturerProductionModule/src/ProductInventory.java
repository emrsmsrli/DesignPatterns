import java.util.ArrayList;
import java.util.List;

public class ProductInventory implements Inventory{
    private List<Product> products;

    public ProductInventory(){
        products = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public boolean hasStock(Object product) {
        if( !(product instanceof Product) || products.indexOf(product) == -1)
            return false;
        return true;
    }

    @Override
    public void addItem(Object product) {
        if(product.getClass() == Product.class)
            products.add((Product) product);
    }

    @Override
    public void removeItem(Object product) {
        if(product.getClass() == Product.class) {
            Product tempProduct = (Product) product;
            products.remove(tempProduct);
            System.out.println("Item removed from inventory. Name: " + tempProduct.getName());
        }
        else
            System.out.println("There is no such product");
    }
}
