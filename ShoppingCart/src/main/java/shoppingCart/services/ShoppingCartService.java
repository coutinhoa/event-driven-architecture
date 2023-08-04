package shoppingCart.services;

import shoppingCart.entities.ShoppingCart;
import shoppingCart.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository repository;
    ShoppingCartService(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    public List<ShoppingCart> getAll(String name) {
        return repository.findAll();
    }

    public ShoppingCart createCart(ShoppingCart cart){return repository.save(cart);}
}
