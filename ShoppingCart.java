package store;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores products selected by the user before purchase.
 */
public class ShoppingCart {
    private List<SalableProduct> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    // Add product to cart; if already there, increase quantity
    public void addProduct(SalableProduct product, int qty) {
        for (SalableProduct item : cartItems) {
            if (item.getName().equalsIgnoreCase(product.getName())) {
                item.setQuantity(item.getQuantity() + qty);
                return;
            }
        }
        // Clone product with requested quantity and add
        SalableProduct copy = new SalableProduct(product.getName(), product.getDescription(), product.getPrice(), qty);
        cartItems.add(copy);
    }

    // Remove product by name
    public void removeProduct(String productName) {
        cartItems.removeIf(item -> item.getName().equalsIgnoreCase(productName));
    }

    // Clear the cart
    public void clear() {
        cartItems.clear();
    }

    // Return list of items in cart
    public List<SalableProduct> getCartItems() {
        return cartItems;
    }

    // Calculate total price of all items
    public double calculateTotal() {
        double total = 0;
        for (SalableProduct item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
