package shoppingCart.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import shoppingCart.dto.ShoppingCartDTO;
import shoppingCart.entities.ShoppingCart;
import shoppingCart.services.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/shopping-cart")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final KafkaTemplate<String, Long> kafkaTemplate;

    ShoppingCartController(
            KafkaTemplate<String, Long> kafkaTemplate, ShoppingCartService shoppingCartService) {
        this.kafkaTemplate = kafkaTemplate;
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getCart(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<ShoppingCart> shoppingCart = shoppingCartService.getAll(name);
        return ResponseEntity.ok(shoppingCart);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        Long userId = shoppingCartDTO.getUserId();
        Map<Long, Integer> productQuantities = shoppingCartDTO.getProductQuantities();
        double totalPrice = calculateTotalPrice(productQuantities);
        shoppingCartService.addToShoppingCart(userId, productQuantities, totalPrice);

        return ResponseEntity.ok("Items added to the shopping cart and sent to Kafka");
    }
    private double calculateTotalPrice(Map<Long, Integer> productQuantities) {
        return 10.00;
    }

}
