package warehouse.controllers;

import jakarta.transaction.Transactional;
import warehouse.entities.Product;
import warehouse.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Transactional
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam (defaultValue="1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<Product> products = productService.getAll(name, page, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Product>> getAvailableProductsInWarehouse() {
        List<Product> products = productService.getAvailableProducts();
        return ResponseEntity.ok(products);
    }

}
