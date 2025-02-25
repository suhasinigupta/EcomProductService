package dev.suhasini.EcomProductService.service;

import dev.suhasini.EcomProductService.entity.Category;
import dev.suhasini.EcomProductService.entity.Product;
import dev.suhasini.EcomProductService.exceptions.ProductNotFoundException;
import dev.suhasini.EcomProductService.repository.CategoryRepository;
import dev.suhasini.EcomProductService.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("productDBService")
public class ProductDBService implements ProductService{

    private ProductRepository productRepository ;
    private CategoryRepository categoryRepository ;

    public ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository ;
        this.categoryRepository = categoryRepository ;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll() ;
        return products;
    }

    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        Product product=productRepository.findById((long) id).orElseThrow(() -> new ProductNotFoundException("Product Not Found for Id: "+id)) ;
        return product;
    }

    @Override
    public Product addProduct(String title, double price, String description, String image, String category) {
        Product product = new Product();
        product.setName(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(image);
        product.setCategory(getCategory(category));
        return productRepository.save(product) ;
    }

    private Category getCategory(String name){
        Optional<Category> optCategory = categoryRepository.findByName(name) ;
        if(optCategory.isPresent()){
            return optCategory.get() ;
        }
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category) ;
    }
}
