package order.services;

import order.entities.Order;
import order.repositories.ProductRepository;
import order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final WarehouseRepository productRepository;
    private final ProductRepository orderDetailsRepository;
    OrderService(OrderRepository repository, WarehouseRepository productRepository, ProductRepository orderDetailsRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }
    public void deleteOrder(Long userId){
        System.out.println(("service delete:"));
        repository.deleteOrderByUserId(userId);
    }
    public Order saveOrder(Order newOrder) {
        var price = productRepository.findById(newOrder.getId()).get();
        var quantity = orderDetailsRepository.findQuantityByOrderId(newOrder.getId());
        newOrder.setTotalPrice(CalculateOrderTotalService.calculate(price.getPrice(), quantity.getQuantity()));
        return repository.save(newOrder);
    }
}
