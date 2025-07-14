package store;

/**
 * Simulates store front operations like purchase and cancel.
 */
public class StoreFront {
    private InventoryManager inventory;
    private ShoppingCart cart;

    public StoreFront() {
        inventory = new InventoryManager();
        cart = new ShoppingCart();
    }

    // Setup store with some products
    public void initializeStore() {
        inventory.addProduct(new SalableProduct("Laptop", "Gaming laptop", 1200.00, 5));
        inventory.addProduct(new SalableProduct("Mouse", "Wireless mouse", 25.99, 15));
        inventory.addProduct(new SalableProduct("Keyboard", "Mechanical keyboard", 89.99, 10));
    }

    // Purchase product (add to cart if enough stock)
    public void purchaseProduct(String productName, int qty) {
        SalableProduct product = inventory.findProductByName(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName);
            return;
        }
        if (product.getQuantity() < qty) {
            System.out.println("Not enough stock for: " + productName);
            return;
        }
        cart.addProduct(product, qty);
        System.out.println(qty + " " + productName + "(s) added to cart.");
    }

    // Cancel purchase (remove from cart)
    public void cancelPurchase(String productName) {
        cart.removeProduct(productName);
        System.out.println(productName + " removed from cart.");
    }

    // Checkout: reduce inventory quantities and clear cart
    public void checkout() {
        for (SalableProduct item : cart.getCartItems()) {
            inventory.updateQuantity(item.getName(), -item.getQuantity());
        }
        double total = cart.calculateTotal();
        cart.clear();
        System.out.printf("Checkout complete! Total amount: $%.2f\n", total);
    }

    // Display all products in inventory
    public void showInventory() {
        System.out.println("Store Inventory:");
        for (SalableProduct product : inventory.getProducts()) {
            System.out.printf("- %s: %s | Price: $%.2f | Quantity: %d\n",
                    product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        }
    }

    // Show contents of the shopping cart
    public void showCart() {
        System.out.println("Shopping Cart Contents:");
        for (SalableProduct item : cart.getCartItems()) {
            System.out.printf("- %s x%d\n", item.getName(), item.getQuantity());
        }
    }
}
