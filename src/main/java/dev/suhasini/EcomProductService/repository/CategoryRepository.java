package dev.suhasini.EcomProductService.repository;

import dev.suhasini.EcomProductService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
       Optional<Category> findByName(String name);
       Category save(Category category);
}
