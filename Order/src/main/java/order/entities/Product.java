package order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Entity
@Getter
@Setter
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    /*public Product() {
    }

    public Product(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }*/
}