package dev.suhasini.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends  BaseModel{
     private String description ;
     private String imageURL ;
     private double price ;
     @ManyToOne
     private Category category ;
}
