package dev.suhasini.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFakeStoreProductRequestDto{
    private String title ;
    private double price;
    private String description ;
    private String image ;
    private String category ;
}