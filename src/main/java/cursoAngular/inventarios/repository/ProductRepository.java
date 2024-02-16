package cursoAngular.inventarios.repository;

import cursoAngular.inventarios.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
