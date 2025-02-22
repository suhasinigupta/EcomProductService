package dev.suhasini.EcomProductService.dto;

import dev.suhasini.EcomProductService.entity.Category;
import dev.suhasini.EcomProductService.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
       private int id ;
       private String title ;
       private double price;
       private String category ;
       private String description ;
       private String image ;

       public  Product toProduct(){
              Product product = new Product();
              product.setName(this.getTitle());
              product.setPrice(this.getPrice());
              product.setDescription(this.getDescription());
              product.setImageURL(this.getImage());
              Category category1=new Category();
              category1.setName(this.getCategory());
              product.setCategory(category1);
              return product;
       }
}


