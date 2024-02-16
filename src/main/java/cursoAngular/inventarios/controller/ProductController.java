package cursoAngular.inventarios.controller;

import cursoAngular.inventarios.exception.ResourceNotFoundException;
import cursoAngular.inventarios.model.Product;
import cursoAngular.inventarios.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Se agrega para saber que es un controlador rest
//localhost:8080/inventario-app Puerto por default donde se levanta la aplicacion de springboot
@RequestMapping("inventario-app") //Context path
@CrossOrigin(value = "http://localhost:4200") //Puerto por default donde se levanta Angular
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    //http://localhost:8080/inventario-app/products
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = this.productService.getProducts();
        logger.info("Get Products");
        products.forEach(product -> {
            logger.info(product.toString());
        });

        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        logger.info("Producto a agregar"+product);
        return this.productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = this.productService.getProductById(id);

        if (product != null) {
            logger.info("Get Product by ID: " + id + product.toString());
            return ResponseEntity.ok(product);
        } else {
            logger.error("ID: " + id + " no encontrado");
            throw new ResourceNotFoundException("Id: " + id + " not Found");
        }

    }

}
