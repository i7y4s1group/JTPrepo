package io.github.maciejlagowski.jtp.labka4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Product {
    //Variables
    private String name;
    private String description;
    private Double price;
    private Double margin;

    //Methods
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + getValue() +
                '}';
    }

    Double getValue() {
        return price + (margin * price);
    }
}
