package shoppingCart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import shoppingCart.dto.ShoppingCartDTO;
import shoppingCart.entities.ShoppingCart;
import shoppingCart.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository repository;
    private final KafkaTemplate<String, ShoppingCartDTO> kafkaTemplate;

    @Autowired
    ShoppingCartService(KafkaTemplate<String, ShoppingCartDTO> kafkaTemplate, ShoppingCartRepository repository) {
        this.kafkaTemplate = kafkaTemplate;
        this.repository = repository;
    }
    public List<ShoppingCart> getAll(String name) {
        return repository.findAll();
    }

    //public ShoppingCartDTO createCart(ShoppingCartDTO cart){return repository.save(cart);}

    public void addToShoppingCart(Long userId, Map<Long, Integer> productQuantities, double totalPrice) {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setUserId(userId);
        shoppingCartDTO.setTotalPrice(totalPrice);
        shoppingCartDTO.setProductQuantities(productQuantities);

        sendShoppingCartToKafka(shoppingCartDTO);
    }

    private void sendShoppingCartToKafka(ShoppingCartDTO shoppingCartDTO) {
        kafkaTemplate.send("shopping-cart-topic", shoppingCartDTO);
    }
}
