package dev.suhasini.EcomProductService.service;

import dev.suhasini.EcomProductService.entity.Product;
import dev.suhasini.EcomProductService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService
{
      List<Product> getAllProducts() ;
      Product getProductById(int id) throws ProductNotFoundException;
      Product addProduct(String title, double price ,String description, String image ,String category );
}
