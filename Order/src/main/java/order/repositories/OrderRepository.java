package order.repositories;

import order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    void deleteOrderByUserId(Long userId);
}
