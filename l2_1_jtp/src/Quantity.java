public class Quantity {
    private String name;
    private int quantity;

    public Quantity(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + " " + quantity;
    }
}
