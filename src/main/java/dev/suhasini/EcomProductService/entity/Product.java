package dev.suhasini.EcomProductService.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
     private long id ;
     private String name ;
     private String description ;
     private String imageURL ;
     private double price ;
     private Category category ;
}
