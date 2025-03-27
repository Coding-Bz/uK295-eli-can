package ch.noseryoung.sbdemo01.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Setter  @Getter
public class Product {
    UUID id;
    String name;
    String description;
    Double price;


    public Product(UUID id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        
    }

    public Product() {
        this.name= "ch/noseryoung/sbdemo01/domain/product";
        this.description= "Description";
        this.price= 0.0;
        this.id = UUID.randomUUID();

    }




}
