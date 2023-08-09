package order.controllers;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import order.entities.Product;
import order.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Transactional
@RestController
//@RequestMapping("/orders/{id}/products")
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {
    private final ProductService orderProductsService;
    ProductController(ProductService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getOrderDetails() {
        List<Product> orderProducts = orderProductsService.getAll();
        return ResponseEntity.ok(orderProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> getOrderDetailsById(@PathVariable Long id) {
        List<Product> orderDetail = orderProductsService.getDetails(id);
        return ResponseEntity.ok(orderDetail);
    }


    @PostMapping
    public Product createNewOrder(@RequestBody Product newOrder) {
        try{
            System.out.println("created order");
            return orderProductsService.createOrder(newOrder);
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
