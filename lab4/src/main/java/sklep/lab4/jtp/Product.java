package sklep.lab4.jtp;

public class Product {
    private String name;
    private double price;
    private String description;

    private Product() {}

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Product product) {
        if(product.description == this.description && product.name == this.name && product.price == this.price)
            return true;
        else return false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " " + price + " " + description;
    }

    public static final class Builder {
        private String name;
        private double price = -1;
        private String description;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            if(name.isEmpty())
                throw new IllegalStateException("Name cannot be empty");
            if(price == -1)
                throw new IllegalStateException("Price cannot be empty");
            if(price <= 0)
                throw new IllegalStateException("Price must be greater than 0");

            Product product = new Product();
            product.name = this.name;
            product.price = this.price;
            product.description = this.description;

            return product;
        }
    }
}
