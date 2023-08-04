package  order.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import order.entities.Order;
import order.services.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Transactional
public class KafkaListeners {
    private final OrderService orderService;

    public KafkaListeners(OrderService service ) {
        this.orderService = service;
    }

    @KafkaListener(topics = "user-deleted", groupId = "foo")
    void listener(String data) throws JsonProcessingException {
        var userId = Long.parseLong(data);
        System.out.println(("Listener received id:" + userId));
        orderService.deleteOrder(userId);
    }


   @KafkaListener(topics = "order-created", groupId = "foo1")
    void listenerShoppingCart(String data) throws JsonProcessingException {
        Order obj = new ObjectMapper().readValue(data, Order.class);
        log.info("data: " + data);
        log.info(("Listener received: " + obj.getOrders_details()));
        orderService.saveOrder(obj);
    }
}
