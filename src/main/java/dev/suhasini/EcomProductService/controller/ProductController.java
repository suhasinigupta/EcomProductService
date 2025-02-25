package dev.suhasini.EcomProductService.controller;

import dev.suhasini.EcomProductService.dto.CreateFakeStoreProductRequestDto;
import dev.suhasini.EcomProductService.dto.ProductResponseDto;
import dev.suhasini.EcomProductService.entity.Product;
import dev.suhasini.EcomProductService.exceptions.ProductNotFoundException;
import dev.suhasini.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService ;

    public ProductController(@Qualifier("productDBService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>>  getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product prod:products){
            productResponseDtos.add(ProductResponseDto.from(prod)) ;
        }
         return ResponseEntity.ok(productResponseDtos) ;
    }

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to EcomProductService!" ;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") int id)throws ProductNotFoundException {
            Product product = productService.getProductById(id);
            ProductResponseDto productResponseDto = ProductResponseDto.from(product) ;
            return ResponseEntity.ok(productResponseDto) ;
    }
     @PostMapping("/products/create")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateFakeStoreProductRequestDto createPoductDto){
        Product responseDto=productService.addProduct(createPoductDto.getTitle(),createPoductDto.getPrice(),createPoductDto.getDescription(),createPoductDto.getImage(),createPoductDto.getCategory()) ;
        return ResponseEntity.ok(ProductResponseDto.from(responseDto)) ;
    }
}
