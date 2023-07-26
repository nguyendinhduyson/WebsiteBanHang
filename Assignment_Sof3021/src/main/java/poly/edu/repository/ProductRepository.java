package poly.edu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.entity.Category;
import poly.edu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Page<Product> findAllByCategory(Category category, Pageable pageable);

}
