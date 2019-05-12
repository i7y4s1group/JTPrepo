package muczyński.mateusz.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
    private double margin;
    private String description;


    public static class ProductBuilder{
        private String name;
        private BigDecimal price;
        private double margin;
        private String description;

        public ProductBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(BigDecimal price){
            this.price = price;
            return this;
        }

        public ProductBuilder setMargin(double margin){
            this.margin = margin;
            return this;
        }

        public ProductBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public Product build(){
            return new Product(name, price, margin, description);
        }
    }
}
