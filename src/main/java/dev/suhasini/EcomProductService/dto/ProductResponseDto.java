package dev.suhasini.EcomProductService.dto;

import dev.suhasini.EcomProductService.entity.Category;
import dev.suhasini.EcomProductService.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private long id ;
    private String name ;
    private String description ;
    private String imageURL ;
    private double price ;
    private String category ;

    public static ProductResponseDto from(Product product){
              ProductResponseDto productResponseDto = new ProductResponseDto();
              productResponseDto.setId(product.getId()); ;
              productResponseDto.setName(product.getName()) ;
              productResponseDto.setDescription(product.getDescription()) ;
              productResponseDto.setImageURL(product.getImageURL()) ;
              productResponseDto.setPrice(product.getPrice()) ;
              productResponseDto.setCategory(product.getCategory().getName()) ;
              return productResponseDto ;
    }
}
