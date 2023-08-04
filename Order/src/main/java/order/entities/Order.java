package order.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetails> orders_details;
}