package order.controllers;

import jakarta.transaction.Transactional;
import order.entities.Order;
import order.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.DELETE})
public class OrderController {

    private final OrderService orderService;
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@RequestParam(name = "user_id", required = false, defaultValue = "") String userId) {
        List<Order> orders = orderService.getAll(userId);
        return ResponseEntity.ok(orders);
    }


    /*@DeleteMapping("/{userId}")
    void deleteUserById(@PathVariable Long userId) {
        log.info("delete");
        orderService.deleteOrder(userId);
    }*/

}
