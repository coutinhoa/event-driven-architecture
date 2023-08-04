package order.services;

import order.entities.OrderDetails;
import order.repositories.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository repository;
    OrderDetailsService(OrderDetailsRepository repository) {
        this.repository = repository;
    }

    public List<OrderDetails> getAll(Long orderId) {
        return repository.findAll();
    }

    public OrderDetails createOrder(OrderDetails order){
        System.out.println("saved order");
        return repository.save(order);
    }
}
