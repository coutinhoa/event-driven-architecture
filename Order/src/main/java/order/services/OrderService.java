package order.services;

import order.entities.Order;
import order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll(String userId) {
        return repository.findAll();
    }
    public void deleteOrder(Long userId){
        System.out.println(("service delete:"));
        repository.deleteOrderByUserId(userId);
    }

    public Order saveOrder(Order order){return repository.save(order);}
}
