package shoppingCart.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import shoppingCart.entities.ShoppingCart;
import shoppingCart.services.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shopping-cart")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ShoppingCartController {

    private final ShoppingCartService service;
    private final KafkaTemplate<String, Long> kafkaTemplate;

    ShoppingCartController(KafkaTemplate<String, Long> kafkaTemplate, ShoppingCartService service) {
        this.kafkaTemplate = kafkaTemplate;
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getCart(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<ShoppingCart> shoppingCart = service.getAll(name);
        return ResponseEntity.ok(shoppingCart);
    }


    @PostMapping
    ShoppingCart newShoppingCart(@RequestBody ShoppingCart newCart) {
        kafkaTemplate.send("order-created", newCart.getId());
        log.info("Order sent "+ newCart.getName());
        return service.createCart(newCart);
    }
}
