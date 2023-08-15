package shoppingCart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingCart.dto.ProductDTO;
import shoppingCart.dto.ShoppingCartDTO;
import shoppingCart.entities.Product;
import shoppingCart.entities.ShoppingCart;
import shoppingCart.repositories.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    public List<ShoppingCart> getAll(String name) {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart createCartWithProducts(ShoppingCartDTO orderRequest) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTotalPrice(orderRequest.getTotalPrice());
        shoppingCart.setUserId(orderRequest.getUserId());

        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : orderRequest.getProducts()) {
            Product product = new Product();
            product.setQuantity(productDTO.getQuantity());
            product.setProductId(productDTO.getProductId());
            product.setShopping_cart(shoppingCart);
            products.add(product);
        }

        shoppingCart.setProducts(products);

        return shoppingCartRepository.save(shoppingCart);
    }
}
