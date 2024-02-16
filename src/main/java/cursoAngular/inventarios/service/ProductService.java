package cursoAngular.inventarios.service;

import cursoAngular.inventarios.model.Product;
import java.util.List;

public interface ProductService {
        public List<Product> getProducts();

        public Product getProductById(Integer idProduct);

        public Product saveProduct(Product product);

        public void deleteProduct(Integer idProduct);
}
