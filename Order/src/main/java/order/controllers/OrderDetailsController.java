package order.controllers;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import order.entities.OrderDetails;
import order.services.OrderDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Transactional
@RestController
//@RequestMapping("/orders/{id}/products")
@RequestMapping("/orders/details")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class OrderDetailsController {
    private final OrderDetailsService orderProductsService;
    OrderDetailsController(OrderDetailsService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }


    @GetMapping
    public ResponseEntity<List<OrderDetails>> getOrderProducts(@RequestParam(name = "order_id", required = false, defaultValue = "") Long orderId) {
        List<OrderDetails> orderProducts = orderProductsService.getAll(orderId);
        return ResponseEntity.ok(orderProducts);
    }


    @PostMapping
    public OrderDetails createNewOrder(@RequestBody OrderDetails newOrder) {
        System.out.println("created order");
        return orderProductsService.createOrder(newOrder);
    }
}
