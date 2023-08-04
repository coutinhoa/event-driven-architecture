package order.controllers;

import jakarta.transaction.Transactional;
import order.entities.Product;
import order.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Transactional
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<Product> products = productService.getAll(name);
        return ResponseEntity.ok(products);
    }

}
