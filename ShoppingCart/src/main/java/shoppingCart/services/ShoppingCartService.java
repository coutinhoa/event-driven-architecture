package shoppingCart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final KafkaTemplate<String, ShoppingCart> kafkaTemplate;
    private final ProductQuantityService productQuantityService;

    @Autowired
    ShoppingCartService(KafkaTemplate<String, ShoppingCart> kafkaTemplate,
                        ShoppingCartRepository shoppingCartRepository,
                        ProductQuantityService productQuantityService) {
        this.kafkaTemplate = kafkaTemplate;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productQuantityService = productQuantityService;
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
            //creates a grpc client that does a request like in postman
            //if product quantity is not enough don't save and send an error, else create cart and order
           int availableQuantity= productQuantityService.getProductQuantity(Math.toIntExact(productDTO.getProductId()));
            if(availableQuantity<)
        }

        shoppingCart.setProducts(products);

        kafkaTemplate.send("shopping-cart-topic", shoppingCart);

        return shoppingCartRepository.save(shoppingCart);
    }
}
