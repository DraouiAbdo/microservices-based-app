package dz.abdelghani.billingservice.model;

import lombok.Data;

@Data
public class Product {
    private  Long id;
    private String name;
    private Double price;
    private Long quantity;
}
