package dev.suhasini.EcomProductService.service;

import dev.suhasini.EcomProductService.dto.CreateFakeStoreProductRequestDto;
import dev.suhasini.EcomProductService.dto.FakeStoreProductResponseDto;
import dev.suhasini.EcomProductService.entity.Product;
import dev.suhasini.EcomProductService.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate ;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreBaseUrl ;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreProductUrl ;

    public FakeStoreProductService(RestTemplate restTemplate ){
           this.restTemplate=restTemplate ;
    }

    public List<Product> getAllProducts() {
        String fakeStoreGetAllProductUrl=fakeStoreBaseUrl.concat(fakeStoreProductUrl) ;

        FakeStoreProductResponseDto[] fakeStoreResponse =
                restTemplate.getForObject(fakeStoreGetAllProductUrl, FakeStoreProductResponseDto[].class) ;
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductResponseDto responseDto : fakeStoreResponse){
            products.add(responseDto.toProduct()) ;
        }
        return products ;
    }

    public Product getProductById(int id) throws ProductNotFoundException {
        String fakeStoreGetProdByIdURL=fakeStoreBaseUrl.concat(fakeStoreProductUrl).concat("/"+ id) ;
        FakeStoreProductResponseDto responseDTO=restTemplate.getForObject(fakeStoreGetProdByIdURL, FakeStoreProductResponseDto.class) ;
        if(responseDTO == null){
            throw new ProductNotFoundException("Product not found for id "+id) ;
        }
        return responseDTO.toProduct();
    }

    public Product addProduct(String title, double price ,String description, String image ,String category ) {
        String createProductURL = fakeStoreBaseUrl.concat(fakeStoreProductUrl) ;
        CreateFakeStoreProductRequestDto createProduct = new CreateFakeStoreProductRequestDto();
        createProduct.setTitle(title);
        createProduct.setPrice(price);
        createProduct.setDescription(description);
        createProduct.setImage(image);
        createProduct.setCategory(category);
        FakeStoreProductResponseDto productResponseDto = restTemplate.postForObject(createProductURL,createProduct FakeStoreProductResponseDto.class);
         return productResponseDto.toProduct();
    }

}
