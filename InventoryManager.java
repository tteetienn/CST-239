package store;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of all products available in inventory.
 */
public class InventoryManager {
    private List<SalableProduct> products;

    public InventoryManager() {
        products = new ArrayList<>();
    }

    public void addProduct(SalableProduct product) {
        products.add(product);
    }

    public List<SalableProduct> getProducts() {
        return products;
    }

    // Finds product by name (case-insensitive)
    public SalableProduct findProductByName(String name) {
        for (SalableProduct product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Updates quantity, returns true if successful
    public boolean updateQuantity(String name, int amount) {
        SalableProduct product = findProductByName(name);
        if (product != null) {
            int newQty = product.getQuantity() + amount;
            if (newQty >= 0) {
                product.setQuantity(newQty);
                return true;
            }
        }
        return false;
    }
}