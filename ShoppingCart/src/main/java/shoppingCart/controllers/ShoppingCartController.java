package shoppingCart.controllers;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import shoppingCart.dto.ShoppingCartDTO;
import shoppingCart.entities.ShoppingCart;
import shoppingCart.repositories.ShoppingCartRepository;
import shoppingCart.services.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/shopping-cart")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final KafkaTemplate<String, ShoppingCartDTO> kafkaTemplate;

    ShoppingCartController(KafkaTemplate<String, ShoppingCartDTO> kafkaTemplate, ShoppingCartService shoppingCartService) {
        this.kafkaTemplate = kafkaTemplate;
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getCart(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<ShoppingCart> shoppingCart = shoppingCartService.getAll(name);
        return ResponseEntity.ok(shoppingCart);
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createCart(@RequestBody ShoppingCartDTO shoppingCart) {
        ShoppingCart createdCart = shoppingCartService.createCartWithProducts(shoppingCart);
        kafkaTemplate.send("shopping-cart-topic", shoppingCart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

}
