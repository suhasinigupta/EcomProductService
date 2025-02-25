package dev.suhasini.EcomProductService.repository;

import dev.suhasini.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

      Product save(Product product);
}
