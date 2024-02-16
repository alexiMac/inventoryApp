package cursoAngular.inventarios.serviceImpl;

import cursoAngular.inventarios.model.Product;
import cursoAngular.inventarios.repository.ProductRepository;
import cursoAngular.inventarios.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Asi forma parte de la fabrica de spring
public class ProductServiceImpl implements ProductService {

    @Autowired //Utilizamos esta anotacion para conectar la capa de servicio con la de repositorio
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer idProduct) {
        return this.productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        this.productRepository.deleteById(idProduct);
    }
}
