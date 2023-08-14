package shoppingCart.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
@Entity
@Table(name = "shoppingCart")
@NoArgsConstructor
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name= "user_id", nullable= false)
    @NonNull
    private Long userId;

    @Column(name= "quantity", nullable= false)
    private int quantity;

    @ElementCollection
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Long, Integer> productQuantities = new HashMap<>(); // Product ID to quantity mapping



}
