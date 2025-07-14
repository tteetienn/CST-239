package store;

/**
 * Main class to demonstrate Store Front operations.
 */
public class Main {
    public static void main(String[] args) {
        StoreFront store = new StoreFront();
        store.initializeStore();

        store.showInventory();

        store.purchaseProduct("Laptop", 2);
        store.purchaseProduct("Mouse", 1);

        store.showCart();

        store.cancelPurchase("Mouse");

        store.showCart();

        store.checkout();

        store.showInventory();
    }
}
